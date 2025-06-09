package practise.contact.test;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Integration_TC_CreateContactWithOrg {
	public static void main(String[] args) throws Throwable {
		//read data from property file
		//step1:get the java representation object of the physical file
		FileInputStream fis1 =new FileInputStream("C:\\Users\\sneha\\Desktop\\data\\vTigerCommonData.Properties");
			//step2:using Properties class,load all the keys
		Properties prop=new Properties();
		prop.load(fis1);
		//step3:get the value based on Key
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		

		//generate random number
				Random random=new Random();
				int randomInt=random.nextInt(1000);
				
				//read testScript data from Excel file
				FileInputStream fis=new FileInputStream("./src/test/resources/td/Daata.xls");
				Workbook wb=WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet("contact");
				Row row = sh.getRow(7);
				String orgName = row.getCell(2).toString()+randomInt;
				String contactLastName = row.getCell(3).getStringCellValue();
				wb.close();
				
				WebDriver driver=null;
				
				if (BROWSER.equals("chrome")) {
					driver=new ChromeDriver();
				                              }
				else if(BROWSER.equals("firefox")) {
					driver=new FirefoxDriver();
				}
				else if(BROWSER.equals("edge")) {
					driver=new EdgeDriver();
				}
				else {
					driver=new ChromeDriver();
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get(URL);
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD );
				driver.findElement(By.id("submitButton")).click();
				
				driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
				driver.findElement(By.xpath("//img[contains(@title,'Create Organization')]")).click();
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();



				//verify header message Expected Result
				String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(headerInfo.contains(orgName))
				System.out.println(orgName+"is created==PASS");
				else
					System.out.println(orgName+"is not created==FAIL");
				
				//step5:navigate to contact module
                driver.findElement(By.linkText("Contacts")).click();
				
				driver.findElement(By.xpath("//img[contains(@title,'Create Contact..')]")).click();
				
				driver.findElement(By.name("lastname")).sendKeys(contactLastName);
				driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
				
				//switch to child   window
				Set<String> set = driver.getWindowHandles();
				Iterator<String> it = set.iterator();
				while(it.hasNext()) {
					String windowID = it.next();
					driver.switchTo().window(windowID);
					
					
					String actUrl = driver.getCurrentUrl();
					if(actUrl.contains("module=Accounts")){
						break;
				}
				}
				
				driver.findElement(By.id("search_txt")).sendKeys(orgName);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
				
				//watch to parent window
				Set<String> set1 = driver.getWindowHandles();
				Iterator<String> it1 = set1.iterator();
				while(it1.hasNext()) {
					String windowID = it1.next();
					driver.switchTo().window(windowID);
					
					
					String actUrl = driver.getCurrentUrl();
					if(actUrl.contains("Contacts&action")){
						break;
					}
				}
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				
				//verify header message Expected Result

                headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(headerInfo.contains(contactLastName)) {
				System.out.println(contactLastName+"is created==PASS");
				}else {
					System.out.println(contactLastName+"is not created==FAIL");
				}
				//verify Header orgName info Expected Result
				String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
				System.out.println(actOrgName);
				if(actOrgName.trim().equals(orgName)) {
					System.out.println(orgName+"is created==PASS");
				}else {
						System.out.println(orgName+"is not created==FAIL");
						System.out.println(orgName+"is not created==FAIL");
					}
				//driver.quit();
			}
	}
	