 package com.pom.contact;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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
import org.testng.annotations.Test;

import com.cast.crm.generic.fileutility.ExcelUtility;
import com.cast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.object.repository.utility.ContactPage;
import com.comcast.crm.object.repository.utility.CreatingNewContactPage;
import com.comcast.crm.object.repository.utility.HomePage;
import com.comcast.crm.object.repository.utility.LoginPage;

public class CreatePOM_Contact_With_Support_Date_Test2 extends BaseClass
{
	@Test
	public  void createContactTestWithSupportDate() throws Throwable {
		//read testScript data from Excel file and read random Number

		String lastName = eLib.getDataFromExcel("contact",4,2)+jLib.getRandomNumber();
				
				HomePage hp=new HomePage(driver);
				hp.getContactsLink().click();
				
				ContactPage cp=new ContactPage(driver);
				cp.getContactBtn().click();
				
				CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
				cncp.getLastNameTF().sendKeys(lastName);
				
				String startDate=jLib.getSystemDateYYYYDDMM();
				String endDate=jLib.getRequiredDateYYYYDDMM(30);
				
				cncp.getSaveBtn().click();
				
				
				//verify start date info Expected Result
				String actStartDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
				if(actStartDate.equals(startDate))
					System.out.println(startDate+"information is verified==PASS");
				else
					System.out.println(startDate+"information is verified==FAIL");
				//verify end date info Expected Result
				String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
				if(actEndDate.equals(endDate))
					System.out.println(endDate+"information is verified==PASS");
				else
					System.out.println(endDate+"information is verified==FAIL");
				//driver.quit();
			}
			}
