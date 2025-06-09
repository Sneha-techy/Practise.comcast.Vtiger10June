package com.comcast.crm.object.repository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsInfoPage {
	WebDriver driver;
	public ProductsInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private  WebElement productHeaderText;
  
	@FindBy(id="dtlview_Product Name")
	private  WebElement productProNameText;
	
	public WebElement getProductHeaderText() {
		return productHeaderText;
	}

	

	public WebElement getProductProNameText() {
		return productProNameText;
	}

	
	
	
	

	//rule3:object Initialization
	//Rule4:Object Encapsulation
	
	



	//rule5:provide Action


}
