package com.comcast.crm.object.repository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	//Rule1: create a separte java class
	 //Rule2:Object Creation
	WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private  WebElement contactHeaderText;
 
	@FindBy(id="dtlview_Last Name")
	private  WebElement lastNameText;
	

	//rule3:object Initialization
	//Rule4:Object Encapsulation
	
	

	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}

	public WebElement getContactNameText() {
		return lastNameText;
	}
	//rule5:provide Action


}
