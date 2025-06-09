package com.comcast.crm.object.repository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	//Rule1: create a separte java class
	 //Rule2:Object Creation
	WebDriver driver;
	public OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//click on green org button
	@FindBy(xpath="//img[contains(@title,'Create Organization')]")
	private  WebElement createOrgBtn;
	
	@FindBy(name="search_text")
	private  WebElement searchEdit;
	
	@FindBy(name="search_field")
	private  WebElement searchDD;
	


	//rule3:object Initialization
	//Rule4:Object Encapsulation
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}
	public WebElement getSearchEdit() {
		return searchEdit;
	}
	public void setSearchEdit(WebElement searchEdit) {
		this.searchEdit = searchEdit;
	}
	public WebElement getSearchDD() {
		return searchDD;
	}
	public void setSearchDD(WebElement searchDD) {
		this.searchDD = searchDD;
	}

	//rule5:provide Action


}
