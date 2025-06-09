package com.comcast.crm.orgtest;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.cast.crm.generic.fileutility.ExcelUtility;
import com.cast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.object.repository.utility.ContactPage;
import com.comcast.crm.object.repository.utility.CreatingNewOrganizationPage;
import com.comcast.crm.object.repository.utility.LoginPage;
import com.comcast.crm.object.repository.utility.OrganizationPage;

public class Create_Org_With_PhoneNumber_Test {
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

		String orgName =eLib.getDataFromExcel("org",7,2)+jLib.getRandomNumber();
		String phoneNumber=eLib.getDataFromExcel("org",7,3);
				
				
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
				
				OrganizationPage cp=new OrganizationPage(driver);
				cp.getCreateOrgBtn().click();
				
				CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
			
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				driver.findElement(By.id("phone")).sendKeys(phoneNumber);
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				
				//verify the Header phone Number info Expected Result
				String actPhoneNum = driver.findElement(By.id("dtlview_Phone")).getText();
				if(actPhoneNum.equals(phoneNumber))
					System.out.println(phoneNumber+"information is verified==PASS");
					else
						System.out.println(phoneNumber+"information is verified==FAIL");


				//driver.quit();
				
				
			}
			}