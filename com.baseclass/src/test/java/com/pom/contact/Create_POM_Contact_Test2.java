package com.pom.contact;

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
import com.comcast.crm.object.repository.utility.CreatingNewOrganizationPage;
import com.comcast.crm.object.repository.utility.HomePage;
import com.comcast.crm.object.repository.utility.LoginPage;
import com.pom.orgpage.OrganizationPage;

public class Create_POM_Contact_Test2 extends BaseClass {
	@Test
	public void createContactTest() throws Throwable {
		// read testScript data from Excel file
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
		// step2:navigate to Contact module
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();
		// step3:click on create contact button
		ContactPage cp = new ContactPage(driver);
		cp.getContactBtn().click();
		// step4:enter aa the details and create new Contact
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContact(lastName);
		// verify Header orgName info Expected Result
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.equals(lastName))
			System.out.println(lastName + "information is verified==PASS");
		else
			System.out.println(lastName + "information is verified==FAIL");
	}

	@Test
	public void createContactWithSupportDate() throws Throwable {
		// read testScript data from Excel file and read random Number

		String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getContactBtn().click();
		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequiredDateYYYYDDMM(30);

		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.getLastNameTF().sendKeys(lastName);
		cncp.getSaveBtn().click();

		// verify start date info Expected Result
		String actStartDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actStartDate.equals(startDate))
			System.out.println(startDate + "information is verified==PASS");
		else
			System.out.println(startDate + "information is verified==FAIL");
		// verify end date info Expected Result
		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actEndDate.equals(endDate))
			System.out.println(endDate + "information is verified==PASS");
		else
			System.out.println(endDate + "information is verified==FAIL");
		// driver.quit();
	}
	@Test
	public  void createContactWithOrganisationIntegration() throws Throwable {
		
		//read testScript data from Excel file and read random Number

		String orgName = eLib.getDataFromExcel("contact",7,2)+jLib.getRandomNumber();
        String contactLastName=eLib.getDataFromExcel("contact", 7, 3);
				
				HomePage hp=new HomePage(driver);
				hp.getOrganizationLink().click();
				
				//click on orgnization page and click on + button
		        OrganizationPage ogpg=new OrganizationPage(driver);
		        ogpg.getCreateOrgBtn().click();
		        
		        // Click Create Organization button
		        CreatingNewOrganizationPage orgPage = new CreatingNewOrganizationPage(driver);
		        orgPage.getOrgNameTField().sendKeys(orgName);
		        orgPage.getSaveBtn().click();

				//verify header message Expected Result
				String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(headerInfo.contains(orgName))
				System.out.println(orgName+"is created==PASS");
				else
					System.out.println(orgName+"is not created==FAIL");
				
				//step5:navigate to contact module
                driver.findElement(By.linkText("Contacts")).click();
				
				driver.findElement(By.xpath("//img[contains(@title,'Create Contact..')]")).click();
				
				driver.findElement(By.name("lastname")).sendKeys(contactLastName);
				driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
				

				//switch to child
				wLib.switchToTabOnURL(driver, "module=Accounts");
				
				driver.findElement(By.id("search_txt")).sendKeys(orgName);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
				

				//switch to parent
				wLib.switchToTabOnURL(driver, "Contacts&action");
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				
				//verify header message Expected Result

                headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(headerInfo.contains(contactLastName)) {
				System.out.println(contactLastName+"is created==PASS");
				}else {
					System.out.println(contactLastName+"is not created==FAIL");
				}
				//verify Header orgName info Expected Result
				String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
				System.out.println(actOrgName);
				if(actOrgName.trim().equals(orgName)) {
					System.out.println(orgName+"is created==PASS");
				}else {
						System.out.println(orgName+"is not created==FAIL");
						System.out.println(orgName+"is not created==FAIL");
					}
				

			}
}