package com.comcast.crm.object.repository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	//Rule1: create a separte java class
	 //Rule2:Object Creation
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[contains(@title,'Create Product')]")
	private  WebElement productsBtn;

	//rule3:object Initialization
	//Rule4:Object Encapsulation



	public WebElement getProductsBtn() {
		return productsBtn;
	}
}
	