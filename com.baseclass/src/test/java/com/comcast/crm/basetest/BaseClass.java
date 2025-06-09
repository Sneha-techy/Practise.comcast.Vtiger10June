package com.comcast.crm.basetest;

import java.sql.SQLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.cast.crm.generic.fileutility.ExcelUtility;
import com.cast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.object.repository.utility.HomePage;
import com.comcast.crm.object.repository.utility.LoginPage;

public class BaseClass {

	/*Create Object*/
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public DataBaseUtility dbLib=new DataBaseUtility();
	public WebDriver driver=null;
	
	
	@BeforeSuite(alwaysRun = true)
	 public void configBS() throws SQLException  {
		System.out.println("=====Connec to DB,Report Config=====");
		dbLib.getDbconnection();
}
	
	@BeforeClass(alwaysRun = true)
	public void configBC(
) throws Throwable 
 {
		System.out.println("=====Launch the browser=====");
		
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
				
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
	}
	@BeforeMethod(alwaysRun = true)
	 public void configBM() throws Throwable  {
		System.out.println("=====login=====");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		LoginPage lp =new LoginPage(driver);
		lp.loginToapp(URL,USERNAME, PASSWORD);

}
	@AfterMethod(alwaysRun = true)
	 public void configAM() throws Throwable  {
		System.out.println("=====logout=====");
		HomePage hp=new HomePage(driver);
		hp.logout();


		
	}
	@AfterClass(alwaysRun = true)
	 public void configAC() throws Throwable  {
		System.out.println("=====Close the Browser=====");
		driver.quit();
	}
		
	@AfterSuite(alwaysRun = true)
	 public void configAS() throws Throwable  {
		System.out.println("=====Close DB,Report backup=====");
		dbLib.closeDbConnection();
	}	
}	
		
		
		
		
		
		
		
		
		
		
