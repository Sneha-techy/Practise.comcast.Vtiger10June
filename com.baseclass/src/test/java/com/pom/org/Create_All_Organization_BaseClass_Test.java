package com.pom.org;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.object.repository.utility.CreatingNewOrganizationPage;
import com.comcast.crm.object.repository.utility.HomePage;
import com.comcast.crm.object.repository.utility.OrganizationInfoPage;
import com.pom.orgpage.OrganizationPage;

public class Create_All_Organization_BaseClass_Test extends BaseClass {
	@Test(groups="SmokeTest")
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
	
	@Test(groups="RegressionTest")
	public void createOrganizationWithIndustriesTest() throws Throwable {

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
	@Test(groups="RegressionTest")
	public void createOrganizationWithPhoneNumberTest() throws Throwable {

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
