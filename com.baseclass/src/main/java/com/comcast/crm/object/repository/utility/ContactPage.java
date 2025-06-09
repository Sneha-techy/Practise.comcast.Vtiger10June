package com.comcast.crm.object.repository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	//Rule1: create a separte java class
		 //Rule2:Object Creation
		WebDriver driver;
		public ContactPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//img[contains(@title,'Create Contact')]")
		private  WebElement contactBtn;

		//rule3:object Initialization
		//Rule4:Object Encapsulation
		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getContactBtn() {
			return contactBtn;
		}

		//rule5:provide Action



		
	}
