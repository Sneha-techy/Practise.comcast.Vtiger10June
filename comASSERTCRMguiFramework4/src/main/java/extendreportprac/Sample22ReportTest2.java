package extendreportprac;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;

public class Sample22ReportTest2 {
	ExtentReports report;
	ExtentTest   test;
	@BeforeSuite
	public void configBS() {
		//Spark report configuration
		String timestamp = LocalDateTime.now().toString().replace(" ", "_").replace(":", "_");
	ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report11"+timestamp+".html");
	        spark.config().setDocumentTitle("CRM Test Suite Results");
	        spark.config().setReportName("CRM Report");
	        spark.config().setTheme(Theme.STANDARD);
	        
	        //add Environment information and create test
	        report=new ExtentReports();
	        report.attachReporter(spark);
	        report.setSystemInfo("OS", "Windows-10");
	        report.setSystemInfo("BROWSER", "CHROME-10");
	}
	@AfterSuite
	public void configAS() {
		report.flush();
		
	}
@Test
public void createContactTest() {
	WebDriver driver=new ChromeDriver();
	driver.get("http://49.249.28.218:8888");
	String timestamp = LocalDateTime.now().toString().replace(" ", "_").replace(":", "_");//capture system date and time
	TakesScreenshot ts= (TakesScreenshot) driver;
    String filePath = ts.getScreenshotAs(OutputType.BASE64);	
    
       test=report.createTest("createContactTest"); 
	test.log(Status.INFO,"login to app");
	test.log(Status.INFO,"navigate to contact page");
	test.log(Status.INFO,"create contact");
	
	if ("HDFC".equals("FC")) {
		test.log(Status.PASS,"contact is created");
	}else {
		test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
	}
	test.log(Status.INFO,"login to app");
	driver.close();
}
}


