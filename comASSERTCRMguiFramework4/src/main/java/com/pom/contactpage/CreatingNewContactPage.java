package com.pom.contactpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	//Rule1: create a separte java class
		 //Rule2:Object Creation
		WebDriver driver;
		public CreatingNewContactPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(name="lastname")
		private WebElement lastNameTF;
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		//rule3:object Initialization
		//Rule4:Object Encapsulation
		public WebElement getLastNameTF() {
			return lastNameTF;
		}


		public WebElement getSaveBtn() {
			return saveBtn;
		}

		//rule5:provide Action
		public void createContact(String lastName) {
	        lastNameTF.sendKeys(lastName);
	        saveBtn.click();
	    }

	}





