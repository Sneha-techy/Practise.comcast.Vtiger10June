package com.pom.org;

import java.time.Duration;

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
import com.comcast.crm.object.repository.utility.CreatingNewOrganizationPage;
import com.comcast.crm.object.repository.utility.HomePage;
import com.comcast.crm.object.repository.utility.LoginPage;
import com.pom.orgpage.OrganizationPage;

public class CreatePOM_Org_With_PhoneNumber_Test extends BaseClass {

	@Test
	public void createContactWithPhoneNumberTest() throws Throwable {

		// Test data
		String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 7, 3).toString();

		// Navigate to Organization page
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		// click on green button
		OrganizationPage ogpg = new OrganizationPage(driver);
		ogpg.getCreateOrgBtn().click();
		Thread.sleep(2000);
		// Create organization with phone number
		CreatingNewOrganizationPage createOrg = new CreatingNewOrganizationPage(driver);
		createOrg.createOrgWithPhoneNumber(orgName, phoneNumber);
		Thread.sleep(2000);
		// Verification (could be moved to another POM class)
		String actualPhoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
		if (actualPhoneNumber.trim().equals(phoneNumber)) {
			System.out.println(phoneNumber + " verified == PASS");
		} else {
			System.out.println(phoneNumber + " mismatch == FAIL");
		}

	}
}