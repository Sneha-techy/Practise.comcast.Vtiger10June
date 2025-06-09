package com.pom.products;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.object.repository.utility.CreateNewProductsPage;
import com.comcast.crm.object.repository.utility.HomePage;
import com.comcast.crm.object.repository.utility.ProductPage;
import com.comcast.crm.object.repository.utility.ProductsInfoPage;
@Listeners(listener.ListImpClass.class)
public class Create_All_Products_BaseClass_Test extends BaseClass{
	@Test(groups="SmokeTest")
	public void createProductTest() throws Throwable {

		// Read test data
		String productsName = eLib.getDataFromExcel("products", 1, 1) + jLib.getRandomNumber();
		// Navigate to Organizations
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();

		ProductPage pgPage = new ProductPage(driver);
		pgPage.getProductsBtn().click();

		// click on orgnization page and click on + button
		CreateNewProductsPage cnprop = new CreateNewProductsPage(driver);
		cnprop.createProducts(productsName);

		ProductsInfoPage proInfo = new ProductsInfoPage(driver);
		// verify header message Expected Result
		String headerInfo = proInfo.getProductHeaderText().getText();
		if (headerInfo.contains(productsName))
			System.out.println(productsName + "is created==PASS");
		else
			System.out.println(productsName + "is not created==FAIL");
		// verify Header orgName info Expected Result
		String actProName = proInfo.getProductProNameText().getText();
		if (actProName.equals(productsName))
			System.out.println(productsName + "is created==PASS");
		else
			System.out.println(productsName + "is not created==FAIL");

	}
	@Test(groups="RegressionTest")
	public void createProductWithCategoryTest() throws Throwable {
	        
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
	@Test(groups="RegressionTest")
	public void createProductWithDatesTest() throws Throwable {
	        
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
