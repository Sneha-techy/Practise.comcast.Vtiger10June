package com.testng.dataprovider;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class GetProductInfo_Excel_Test {
	@Test(dataProvider="getData")
public void getProductInfoTest(String brandName,String productName) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get("https://www.amazon.in/?&tag=googhydrabk1-21");

//search product

driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
//capture product info
String x="(//span[contains(text(),'"+productName+"')]/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span)[1]";
String price=driver.findElement(By.xpath(x)).getText();
Thread.sleep(2000);
System.out.println(price);
Thread.sleep(2000);
driver.quit();
	}
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib=new ExcelUtility();
		int rowCount = eLib.getRowcount("iphone");
		Object[][] objArr=new Object[rowCount][2];
		
		for(int i=0;i<rowCount;i++) {
			objArr[i][0]=eLib.getDataFromExcel("iphone", i+1, 0);
			objArr[i][1]=eLib.getDataFromExcel("iphone", i+1, 1);
			Thread.sleep(2000);
		}
		return objArr;                                                            
		}
		}

		
		
		
	

