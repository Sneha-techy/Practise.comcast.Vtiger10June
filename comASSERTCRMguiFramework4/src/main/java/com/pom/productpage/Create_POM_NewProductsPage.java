package com.pom.productpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_POM_NewProductsPage {
	WebDriver driver;

	public Create_POM_NewProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	 @FindBy(name = "productname")
	    private WebElement productNamTF;


		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;

		public WebElement getTypeDropdown() {
			return productNamTF;
		}


		public WebElement getSaveBtn() {
			return saveBtn;
		}
		public void createProducts(String productsName) {
			productNamTF.sendKeys(productsName);
	        saveBtn.click();
	    }

		
		
		
		
}