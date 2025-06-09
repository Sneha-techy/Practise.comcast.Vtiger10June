package com.pom.products;


	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.cast.crm.generic.fileutility.ExcelUtility;
	import com.cast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.object.repository.utility.CreateNewProductsPage;
import com.comcast.crm.object.repository.utility.CreatingNewOrganizationPage;
	import com.comcast.crm.object.repository.utility.HomePage;
	import com.comcast.crm.object.repository.utility.LoginPage;
import com.comcast.crm.object.repository.utility.ProductPage;
import com.comcast.crm.object.repository.utility.ProductsInfoPage;
import com.pom.orgpage.OrganizationPage;

public class CreatePOM_Products_with_Category extends BaseClass {
	@Test
	public void createContactWithCategoryTest() throws Throwable {
	        
	        // Read test data
	        String productsName = eLib.getDataFromExcel("products",4,1) + jLib.getRandomNumber();
	        String productsCgory= eLib.getDataFromExcel("products",4,2);

	        // Navigate to Organizations
	        HomePage hp = new HomePage(driver);
	        hp.getProductsLink().click();
	        
	        ProductPage pgPage=new ProductPage(driver);
	        pgPage.getProductsBtn().click();
	        
	      //click on orgnization page and click on + button
	        CreateNewProductsPage cnprop =new CreateNewProductsPage(driver);
	        cnprop.createProductWithCategory(productsName, productsCgory, wLib);
	        
	        ProductsInfoPage proInfo=new ProductsInfoPage(driver);
	      //verify header message Expected Result
			String headerInfo = proInfo.getProductHeaderText().getText();
			if(headerInfo.contains(productsName))
			System.out.println(productsName+"is created==PASS");
			else
				System.out.println(productsName+"is not created==FAIL");
			//verify Header orgName info Expected Result
			String actProName = proInfo.getProductProNameText().getText();
			if(actProName.equals(productsName))
				System.out.println(productsName+"is created==PASS");
				else
					System.out.println(productsName+"is not created==FAIL");
		}
		}
	        