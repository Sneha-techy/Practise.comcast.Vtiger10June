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

public class CreatePOM_Product_With_Dates extends BaseClass {
	@Test
	public void createContactWithDatesTest() throws Throwable {
	        
	        // Read test data
	        String productsName = eLib.getDataFromExcel("products", 1,1) + jLib.getRandomNumber();
	        String startDate=jLib.getStartDateYYYYMMDD();
			String endDate=jLib.getEndDateYYYYMMDD(30);

             Thread.sleep(2000);
	        // Navigate to Organizations
	        HomePage hp = new HomePage(driver);
	        hp.getProductsLink().click();
	        Thread.sleep(2000);
	        ProductPage pgPage=new ProductPage(driver);
	        pgPage.getProductsBtn().click();
	        Thread.sleep(2000);
	      //click on orgnization page and click on + button
	        CreateNewProductsPage cnprop =new CreateNewProductsPage(driver);
	        cnprop.createProductWithDates(productsName,startDate,endDate);
	        Thread.sleep(2000);
	     // Verification
	        String actualStartDate = cnprop.getSalesStartDateTF().getText().trim();
	        String actualEndDate =  cnprop.getSalesEndDateTF().getText().trim();

	        if (actualStartDate.equals(startDate)) {
	            System.out.println(" Sales Start Date verified: " + actualStartDate);
	        } else {
	            System.out.println(" Sales Start Date mismatch: " + actualStartDate + " != " + startDate);
	        }

	        if (actualEndDate.equals(endDate)) {
	            System.out.println(" Sales End Date verified: " + actualEndDate);
	        } else {
	            System.out.println(" Sales End Date mismatch: " + actualEndDate + " != " + endDate);
	        }
	    }
 
	    }
	        


	    

			
	        