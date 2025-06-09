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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.cast.crm.generic.fileutility.ExcelUtility;
import com.cast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.object.repository.utility.LoginPage;

public class DeleteOrganizationTest {
public static void main(String[] args) throws Throwable {
	/*Create Object*/
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
    JavaUtility jLib=new JavaUtility();
    
  //read common data 
	String BROWSER = fLib.getDataFromPropertiesFile("browser");
	String URL = fLib.getDataFromPropertiesFile("url");
	String USERNAME = fLib.getDataFromPropertiesFile("username");
	String PASSWORD = fLib.getDataFromPropertiesFile("password");

	
			
	//read testScript data from Excel file and read random Number

	String orgName = eLib.getDataFromExcel("org",1,2)+jLib.getRandomNumber();

			
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
			
			/*
			 * lp.getUsernameEdit().sendKeys("admin");
			 * lp.getPasswordEdit().sendKeys("admin"); lp.getLoginBtn().click();
			 */
			LoginPage lp =new LoginPage(driver);
			lp.loginToapp(URL,USERNAME, PASSWORD);
//go back to Organization Page
			//search for Organization
			//In Dynamic webtable select and delete org
			//step5: logout
			
			
			 	}
		}