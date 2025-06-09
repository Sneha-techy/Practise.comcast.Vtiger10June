package com.testng.dataprovider;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class GetProductInfoTest {
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

driver.quit();
	}
	@DataProvider
	public Object[][] getData() throws InterruptedException {
		Object[][] objArr=new Object[3][2];
		objArr[0][0]="iphone";                                                                   
		objArr[0][1]="Apple iPhone 15 (128 GB) - Blue";
		Thread.sleep(2000);
		objArr[1][0]="iphone";
		objArr[1][1]="Phone 16e 128 GB";
		Thread.sleep(2000);
		
		objArr[2][0]="iphone";
		objArr[2][1]="Apple iPhone 13 (128GB) - Blue";
		
		return objArr;
		
		
	}
	}

