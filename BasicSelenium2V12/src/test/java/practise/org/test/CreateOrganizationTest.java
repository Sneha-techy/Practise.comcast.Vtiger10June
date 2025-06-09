package practise.org.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class CreateOrganizationTest {
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
			FileInputStream fis=new FileInputStream("./src/test/resources/td/Data.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("org");
			Row row = sh.getRow(1);
			String orgName = row.getCell(0).toString()+randomInt;
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
			Thread.sleep(3000);
			driver.findElement(By.name("button")).click();
			//verify header message Expected Result
			String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerInfo.contains(orgName))
			System.out.println(orgName+"is created==PASS");
			else
				System.out.println(orgName+"is not created==FAIL");
			//verify Header orgName info Expected Result
			String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
			if(actOrgName.equals(orgName))
				System.out.println(orgName+"is created==PASS");
				else
					System.out.println(orgName+"is not created==FAIL");
			//driver.quit();
		}
		}