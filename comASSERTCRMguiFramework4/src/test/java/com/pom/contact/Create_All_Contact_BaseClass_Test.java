package com.pom.contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.object.repository.utility.ContactInfoPage;
import com.comcast.crm.object.repository.utility.ContactPage;
import com.comcast.crm.object.repository.utility.CreatingNewContactPage;
import com.comcast.crm.object.repository.utility.CreatingNewOrganizationPage;
import com.comcast.crm.object.repository.utility.HomePage;
import com.pom.orgpage.OrganizationPage;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;
@Listeners(listener.ListImpClass.class)
public class Create_All_Contact_BaseClass_Test extends BaseClass{
	@Test(groups="SmokeTest")
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
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		
		
		  String actheaderInfo = cip.getContactHeaderText().getText();
		  boolean status = actheaderInfo.contains(lastName);
		  Assert.assertEquals(status, true);
			
		// verify Header orgName info Expected Result
		String actLastName = cip.getContactNameText().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actLastName,lastName);
		soft.assertAll();
	}
	
	
	
	
	@Test(groups="RegressionTest")
	public void createContactWithSupportDate() throws Throwable {
		// read testScript data from Excel file and read random Number

		String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getContactBtn().click();
		String startDate = jLib.getStartDateYYYYMMDD();
		String endDate = jLib.getEndDateYYYYMMDD(30);
		System.out.println(startDate);
		System.out.println(endDate);

		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.getLastNameTF().sendKeys(lastName);
		cncp.getSaveBtn().click();

		// verify start date info Expected Result
		
			
		
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		System.out.println(actStartDate);
		boolean status1 = actStartDate.contains(startDate);
		//Assert.assertEquals(actStartDate,startDate);
		Assert.assertEquals(status1, true);
		
		
		// verify end date info Expected Result
		String actEndDate = driver.findElement(By.id("mouseArea_Support End Date")).getText();
		System.out.println(actEndDate);
		boolean status2 = actEndDate.contains(endDate);
		//Assert.assertEquals(actEndDate,endDate );
		Assert.assertEquals(status2, true);
			
	}
	@Test(groups="RegressionTest")
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
				 boolean status = headerInfo.contains(orgName);
				  Assert.assertEquals(status, true);
				
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
                boolean status1 = headerInfo.contains(contactLastName);
				  Assert.assertEquals(status1, true);
				
                
				//verify Header orgName info Expected Result
				String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
				System.out.println(actOrgName);
				boolean status2 = headerInfo.contains(orgName);
				  Assert.assertEquals(status2, true);
	}
}
			