package com.tekpy.assertsofthard;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class AssertHomePageVerificationTest extends BaseClass {
@Test
public void homePageTest(Method mtd)
{
	System.out.println(mtd.getName()+"Test start");
	String expectedPage = "HomePage";
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://49.249.28.218:8888");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	String actTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	if (actTitle.trim().equals(expectedPage)) {
        System.out.println( expectedPage + "Page is verified==Pass ");
    } else {
        System.out.println(expectedPage +"Page is not verified==FAIL");
    }
	System.out.println(mtd.getName()+"Test End");

	}

@Test
public void verifyLogoHomePageTest(Method mtd)
{
	System.out.println(mtd.getName()+"Test start");


	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://49.249.28.218:8888");
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
	if (status) {
        System.out.println( "Logo is verified==Pass ");
    } else {
        System.out.println("Logo is not verified==FAIL");
    }
	System.out.println(mtd.getName()+"Test End");

}
}