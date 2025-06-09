package com.comcast.crm.object.repository.utility;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class Creating_New_Opportunity_Page {
	//Rule1: create a separte java class
	 //Rule2:Object Creation
	WebDriver driver;
	public Creating_New_Opportunity_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	     @FindBy(name = "potentialname")
	    private WebElement potentialNameTF;

	     @FindBy(id="related_to_type")
	     private WebElement relatedToDropdown;

		@FindBy(xpath = "(//img[@title='Select'])[1]")
		private WebElement relatedToPlusBtn;
		
		
		@FindBy (partialLinkText="instagram")
	     private WebElement orgName;

		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveBtn1;
		
		
		 @FindBy(id="search_txt")
	     private WebElement searchTF;
		 
		 @FindBy(name="search")
		 private WebElement searchNowBtn;


		 @FindBy(id="1")
	     private WebElement orgNameList;
				 
		 @FindBy(name ="button")
		 private WebElement saveBTn2;
		 
		

		
		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getPotentialNameTF() {
			return potentialNameTF;
		}

		public WebElement getRelatedToDropdown() {
			return relatedToDropdown;
		}

		public WebElement getRelatedToPlusBtn() {
			return relatedToPlusBtn;
		}

		public WebElement getOrgName() {
			return orgName;
		}

		public WebElement getSaveBtn1() {
			return saveBtn1;
		}

		public WebElement getSearchTF() {
			return searchTF;
		}

		public WebElement getSearchNowBtn() {
			return searchNowBtn;
		}

		public WebElement getOrgNameList() {
			return orgNameList;
		}

		public WebElement getSaveBTn2() {
			return saveBTn2;
		}

		public void setRelatedToPlusBtn(WebElement relatedToPlusBtn) {
			this.relatedToPlusBtn = relatedToPlusBtn;
		}

		public void createNewOpportunity(String potentialName,String orgName,String organization) {
			potentialNameTF.sendKeys(potentialName);
			 Select potentSelect = new Select(relatedToDropdown);
			 potentSelect.selectByVisibleText(organization);
			 relatedToPlusBtn.click();
		}
		public void createNewOpportunityWithOrganization(String potentialName, String organizationType, String orgName, WebDriverUtility wLib) {
		    potentialNameTF.sendKeys(potentialName);

		    Select select = new Select(relatedToDropdown);
		    select.selectByVisibleText(organizationType);
		    
		    
		    relatedToPlusBtn.click();
		    wLib.waitUntilElementIsClickable(driver,relatedToPlusBtn) ;
		    String parentWindowId = driver.getWindowHandle();
		    Set<String> allWindowIds = driver.getWindowHandles();

		    for (String winId : allWindowIds) {
		        if (!winId.equals(parentWindowId)) {
		            driver.switchTo().window(winId);
		            break;
		        }
		    }

		    // Search and select organization
		    searchTF.sendKeys(orgName);
		    searchNowBtn.click();
		    orgNameList.click();  // Clicking the first result (id="1")

		    // Switch back to parent window
		    driver.switchTo().window(parentWindowId);

		    saveBtn1.click(); // Save opportunity
		}
	   
}			 
	         
		

		 
		 
		 
		 
		 
