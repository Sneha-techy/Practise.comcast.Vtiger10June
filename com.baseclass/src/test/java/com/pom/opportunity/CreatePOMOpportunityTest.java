package com.pom.opportunity;


	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	import com.cast.crm.generic.fileutility.ExcelUtility;
	import com.cast.crm.generic.fileutility.FileUtility;
	import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.object.repository.utility.CreateNewProductsPage;
import com.comcast.crm.object.repository.utility.CreatingNewOrganizationPage;
import com.comcast.crm.object.repository.utility.Creating_New_Opportunity_Page;
import com.comcast.crm.object.repository.utility.HomePage;
	import com.comcast.crm.object.repository.utility.LoginPage;
import com.comcast.crm.object.repository.utility.OpportunitiesPage;
import com.comcast.crm.object.repository.utility.Opportunity_Information_Page;
import com.comcast.crm.object.repository.utility.OrganizationInfoPage;
import com.comcast.crm.object.repository.utility.ProductPage;
import com.comcast.crm.object.repository.utility.ProductsInfoPage;
import com.pom.orgpage.OrganizationPage;

public class CreatePOMOpportunityTest {
	    public static void main(String[] args) throws Throwable {
	        FileUtility fLib = new FileUtility();
	        ExcelUtility eLib = new ExcelUtility();
	        JavaUtility jLib = new JavaUtility();
	        WebDriverUtility wLib = new WebDriverUtility();
	        
	        // Read configuration
	        String BROWSER = fLib.getDataFromPropertiesFile("browser");
	        String URL = fLib.getDataFromPropertiesFile("url");
	        String USERNAME = fLib.getDataFromPropertiesFile("username");
	        String PASSWORD = fLib.getDataFromPropertiesFile("password");

	        // Read test data
	        String opportunityName = eLib.getDataFromExcel("opportunity",1,1) + jLib.getRandomNumber();
	        String relatedToDD = eLib.getDataFromExcel("opportunity",1,2);
	        String relatedOrgName = eLib.getDataFromExcel("opportunity",1,3);
	        
	        WebDriver driver = null;
	        if (BROWSER.equalsIgnoreCase("chrome")) {
	            driver = new ChromeDriver();
	        } else if (BROWSER.equalsIgnoreCase("firefox")) {
	            driver = new FirefoxDriver();
	        } else if (BROWSER.equalsIgnoreCase("edge")) {
	            driver = new EdgeDriver();
	        } else {
	            driver = new ChromeDriver();
	        }

	        wLib.waitForPageToLoad(driver); 
	        driver.get(URL);

	        // Login
	        LoginPage lp = new LoginPage(driver);
	        lp.loginToapp(URL,USERNAME, PASSWORD);

	        // Navigate to Organizations
	        HomePage hp = new HomePage(driver);
	        hp.getOpportunitiesLink().click();
	        
	        OpportunitiesPage oppPage=new OpportunitiesPage(driver);
	        oppPage.getOpportunitiesBtn().click();
	        
	      //click on organization page and click on + button
	     Creating_New_Opportunity_Page cnpoop =new Creating_New_Opportunity_Page(driver);
                 cnpoop.createNewOpportunityWithOrganization( opportunityName,relatedToDD, relatedOrgName, wLib);
                
	        
	        Opportunity_Information_Page oppoInfo=new Opportunity_Information_Page(driver);
	      //verify header message Expected Result
			String headerInfo = oppoInfo.getOppportunityHeaderText().getText();
			if(headerInfo.contains(opportunityName))
			System.out.println(opportunityName+"is created==PASS");
			else
				System.out.println(opportunityName+"is not created==FAIL");
			//verify Header orgName info Expected Result
			String actProName = oppoInfo.getOpportunityOrgNameText().getText();
			if(actProName.equals(opportunityName))
				System.out.println(opportunityName+"is created==PASS");
				else
					System.out.println(opportunityName+"is not created==FAIL");
			//driver.quit();
		}
		}
	        