package com.pom.org;


	import java.time.Duration;

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
	import com.comcast.crm.object.repository.utility.CreatingNewOrganizationPage;
	import com.comcast.crm.object.repository.utility.HomePage;
	import com.comcast.crm.object.repository.utility.LoginPage;
	import com.comcast.crm.object.repository.utility.OrganizationInfoPage;
import com.pom.orgpage.OrganizationPage;

	public class CreatePOMOrganizationTest  extends BaseClass {
		@Test
		public void createContactTest() throws Throwable {
	        // Read test data from excel
	              String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

	        // Navigate to Organizations page via HomePage POM
	        HomePage hp = new HomePage(driver);
	        hp.getOrganizationLink().click();

	        //click on orgnization page and click on + button
	        OrganizationPage ogpg=new OrganizationPage(driver);
	        ogpg.getCreateOrgBtn().click();
	        
	        // Click Create Organization button
	        CreatingNewOrganizationPage orgPage = new CreatingNewOrganizationPage(driver);
	        orgPage.getOrgNameTField().sendKeys(orgName);
	        orgPage.getSaveBtn().click();

	        // Verify organization creation
	        OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
	        String actualOrgName = orgInfo.getOrganizationHeaderText().getText();

	        if (actualOrgName.contains(orgName)) {
	            System.out.println(orgName + " created successfully - PASS");
	        } else {
	            System.out.println(orgName + " creation failed - FAIL");
	        }
	    }
		
	}