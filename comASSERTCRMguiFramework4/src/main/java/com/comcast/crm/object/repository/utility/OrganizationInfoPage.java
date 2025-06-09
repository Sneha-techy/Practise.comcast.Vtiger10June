package com.comcast.crm.object.repository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	//Rule1: create a separte java class
		 //Rule2:Object Creation
		WebDriver driver;
		public OrganizationInfoPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private  WebElement organizationHeaderText;
      
		@FindBy(id="dtlview_Organization Name")
		private  WebElement organizationOrgNameText;
		

		//rule3:object Initialization
		//Rule4:Object Encapsulation
		
		

		public WebElement getOrganizationHeaderText() {
			return organizationHeaderText;
		}

		public WebElement getOrganizationOrgNameText() {
			return organizationOrgNameText;
		}
		//rule5:provide Action


	}
