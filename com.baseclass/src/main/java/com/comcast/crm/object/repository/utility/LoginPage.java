package com.comcast.crm.object.repository.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

import genericutility.BaseClass;

public class LoginPage extends WebDriverUtility
{
     //Rule1: create a separte java class
	 //Rule2:Object Creation
	
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private  WebElement usernameEdit;
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	//rule3:object Initialization
	//Rule4:Object Encapsulation
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}
	public WebElement getPasswordEdit() {
		return passwordEdit;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//rule5:provide Action
	public void loginToapp(String url,String username,String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();
	}
}
