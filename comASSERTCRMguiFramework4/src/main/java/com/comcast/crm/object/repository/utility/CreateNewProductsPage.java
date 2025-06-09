package com.comcast.crm.object.repository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewProductsPage {
	WebDriver driver;

	public CreateNewProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	     @FindBy(name = "productname")
	    private WebElement productNameTF;

	     @FindBy(name = "productcategory")
	     private WebElement productCategoryDropdown;

		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;

		@FindBy(name="sales_start_date")
	    private WebElement salesStartDateTF;

	    @FindBy(name="sales_end_date")
	    private WebElement salesEndDateTF;
	    
	    		



	    // Getters (optional if you want individual access)
	    public WebElement getProductNameTF() {
	        return productNameTF;
	    }

	    public WebElement getSalesStartDateTF() {
	        return salesStartDateTF;
	    }

	    public WebElement getSalesEndDateTF() {
	        return salesEndDateTF;
	    }
	    

	    public WebElement getProductCategoryDropdown() {
			return productCategoryDropdown;
		}
	    
	    		

		public WebElement getSaveBtn() {
	        return saveBtn;
	    }

	    public void createProducts(String productsName) {
			productNameTF.sendKeys(productsName);
			
	        saveBtn.click();
	    }
	    // Reusable business method to fill the form
	    public void createProductWithDates(String name, String startDate, String endDate) {
	        productNameTF.sendKeys(name);
	       // salesStartDateTF.clear();
	        salesStartDateTF.sendKeys(startDate);
	       // salesEndDateTF.clear();
	        salesEndDateTF.sendKeys(endDate);
	        saveBtn.click();
	    }
	    
	    public void createProductWithCategory(String productName,  String category, WebDriverUtility wLib) {
	        productNameTF.sendKeys(productName);
	        wLib.select(productCategoryDropdown, category);
	        saveBtn.click();
	    }
}




		

		
		
		
		
