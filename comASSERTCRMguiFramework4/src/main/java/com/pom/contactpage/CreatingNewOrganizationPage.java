package com.pom.contactpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {


	WebDriver driver;

	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

		// Web elements
		@FindBy(name = "accountname")
		private WebElement orgNameTF;


		@FindBy(id = "phone")
		private WebElement phoneNumberTF;
		//industry
		@FindBy(name = "industry")
	    private WebElement industryDropdown;
          //type
	    @FindBy(name = "accounttype")
	    private WebElement typeDropdown;


		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;

		// Getters (Rule 4)
		public WebElement getOrgNameTField() {
			return orgNameTF;

		}

		public WebElement getPhoneNumberField() {
			return phoneNumberTF;

		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		public WebElement getIndustryDropdown() {
			return industryDropdown;
		}

		public WebElement getTypeDropdown() {
			return typeDropdown;
		}

		// Actions (Rule 5)
		public void createOrgWithPhoneNumber(String orgName, String phone) {
			orgNameTF.sendKeys(orgName);
			phoneNumberTF.sendKeys(phone);
			saveBtn.click();
		}
		// Reusable business logic method
		public void createOrgWithIndustryAndType(String org, String industry, String type) {
		    orgNameTF.sendKeys(org);
		    
		    Select industrySelect = new Select( industryDropdown);
		    industrySelect.selectByValue(industry);
		    
		    Select typeSelect = new Select(typeDropdown);
		    typeSelect.selectByValue(type);
		    
		    saveBtn.click();
		}
	}
	


