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

public class CreatePOM_Organization_With_Industries_Test extends BaseClass {
	@Test
	public void createContactWithIndustriesTest() throws Throwable {

		// Read test data
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 1, 3); // Use exact dropdown text
		String type = eLib.getDataFromExcel("org", 1, 4);

		// Navigate to Organizations
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		// click on orgnization page and click on + button
		OrganizationPage ogpg = new OrganizationPage(driver);
		ogpg.getCreateOrgBtn().click();

		// Create organization with industry and type
		CreatingNewOrganizationPage createOrgPage = new CreatingNewOrganizationPage(driver);
		createOrgPage.createOrgWithIndustryAndType(orgName, industry, type);

		// Verify Industry
		String actualIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actualIndustry.equals(industry)) {
			System.out.println("Industry verified: " + industry + " == PASS");
		} else {
			System.out.println("Expected industry: " + industry + ", but found: " + actualIndustry + " == FAIL");
		}

		// Verify Type
		String actualType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actualType.equals(type)) {
			System.out.println("Type verified: " + type + " == PASS");
		} else {
			System.out.println("Expected type: " + type + ", but found: " + actualType + " == FAIL");
		}

	}
}