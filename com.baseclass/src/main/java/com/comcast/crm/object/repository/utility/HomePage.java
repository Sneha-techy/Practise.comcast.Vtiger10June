package com.comcast.crm.object.repository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//Rule1: create a separte java class
	 //Rule2:Object Creation
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Organizations")
	private  WebElement organizationLink;
	

	@FindBy(linkText="Contacts")
	private  WebElement contactsLink;
	
	@FindBy(linkText="Calendar")
	private  WebElement calendarLink;
	
	@FindBy(linkText="Opportunities")
	private  WebElement opportunitiesLink;
	
	@FindBy(linkText="Products")
	private  WebElement productsLink;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logOutBtn;
	
	@FindBy(linkText="Sign Out")
	private  WebElement signOutLink;
	
	

	//rule3:object Initialization
	//Rule4:Object Encapsulation
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getCalendarLink() {
		return calendarLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}


public void logout() {
Actions act=new Actions(driver);
act.moveToElement(logOutBtn).perform();
act.click(signOutLink).perform();

	

	//rule5:provide Action

}
}
