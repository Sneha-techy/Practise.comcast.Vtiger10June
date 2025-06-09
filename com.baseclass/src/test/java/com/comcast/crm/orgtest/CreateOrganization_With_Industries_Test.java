package com.comcast.crm.orgtest;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.cast.crm.generic.fileutility.ExcelUtility;
import com.cast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.object.repository.utility.LoginPage;

public class CreateOrganization_With_Industries_Test {
public static void main(String[] args) throws Throwable {
	/*Create Object*/
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();

	String BROWSER = fLib.getDataFromPropertiesFile("browser");
	String URL = fLib.getDataFromPropertiesFile("url");
	String USERNAME = fLib.getDataFromPropertiesFile("username");
	String PASSWORD = fLib.getDataFromPropertiesFile("password");
	
			//read testScript data from Excel file

			
	//read testScript data from Excel file and read random Number

		String orgName = eLib.getDataFromExcel("org",1,2)+jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org",1,3)+jLib.getRandomNumber();
		String type = eLib.getDataFromExcel("org",1,4)+jLib.getRandomNumber();
				
			
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
			LoginPage lp =new LoginPage(driver);
			lp.loginToapp(URL,USERNAME, PASSWORD);
			
			driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
			driver.findElement(By.xpath("//img[contains(@title,'Create Organization')]")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			//Thread.sleep(3000);
			WebElement wbs = driver.findElement(By.xpath("//select[@name='industry']"));
			Select sel1=new Select(wbs);
			sel1.selectByValue("Energy");
			
			WebElement wbs2 = driver.findElement(By.xpath("//select[@name='accounttype']"));
			Select sel2=new Select(wbs2);
			sel2.selectByValue("Press");
			
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//verify the industry info Expected Result
			String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
			if(actIndustries.equals(industry))
				System.out.println(industry+"information is verified==PASS");
				else
					System.out.println(industry+"information is verified==FAIL");
			//verify type info Expected Result
			String actType = driver.findElement(By.id("dtlview_Type")).getText();
			if(actType.equals(type))
				System.out.println(type+"information is verified==PASS");
				else
					System.out.println(type+"information is verified==FAIL");
			//driver.quit();
			
			
		}
		}