package com.comcast.crm.object.repository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Opportunity_Information_Page {
	//Rule1: create a separte java class
	 //Rule2:Object Creation
	WebDriver driver;
	public Opportunity_Information_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private  WebElement opportunityHeaderText;
 
	@FindBy(id="mouseArea_Opportunity Name")
	private  WebElement opportunityNameText;
	

	//rule3:object Initialization
	//Rule4:Object Encapsulation
	
	

	public WebElement getOppportunityHeaderText() {
		return opportunityHeaderText;
	}

	public WebElement getOpportunityOrgNameText() {
		return opportunityNameText;
	}
	//rule5:provide Action


}
