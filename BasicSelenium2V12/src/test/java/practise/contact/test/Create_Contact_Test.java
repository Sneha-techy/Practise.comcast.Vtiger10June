package practise.contact.test;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Create_Contact_Test {
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
				Row row = sh.getRow(1);
				String lastName = row.getCell(2).toString()+randomInt;
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
				
				driver.findElement(By.linkText("Contacts")).click();
				
				driver.findElement(By.xpath("//img[contains(@title,'Create Contact..')]")).click();
				
				driver.findElement(By.name("lastname")).sendKeys(lastName);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				
				
				//verify Header orgName info Expected Result
				String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
				if(actLastName.equals(lastName))
					System.out.println(lastName+"information is verified==PASS");
				else
					System.out.println(lastName+"information is verified==FAIL");
				//driver.quit();
			}
			}
