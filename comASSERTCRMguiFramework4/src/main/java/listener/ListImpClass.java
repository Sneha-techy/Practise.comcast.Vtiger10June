package listener;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;


public class ListImpClass implements ITestListener,ISuiteListener{
			public ExtentReports report;
			public ExtentTest test;
			@Override
			public void onStart(ISuite suite) {
				
				//Spark report configuration
				 String timestamp = new Date(0).toString().replace(" ", "_").replace(":", "_");
			ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_51"+timestamp+".html");
			        spark.config().setDocumentTitle("CRM Test Suite Results");
			        spark.config().setReportName("CRM Report");
			        spark.config().setTheme(Theme.STANDARD);
			        
			        //add Environment information and create test
			        report=new ExtentReports();
			        report.attachReporter(spark);
			        report.setSystemInfo("OS", "Windows-10");
			        report.setSystemInfo("BROWSER", "CHROME-100");
				Reporter.log("Report Configuration");
				ISuiteListener.super.onStart(suite);
			}  

 @Override
	public void onFinish(ISuite suite) {
	 Reporter.log("Report backup");
		report.flush();
	}
 @Override
	public void onTestStart(ITestResult result) {
	 Reporter.log("=================="+result.getMethod().getMethodName()+"===START==");
	 test = report.createTest(result.getMethod().getMethodName()); 
	 test.log(Status.INFO, result.getMethod().getMethodName()+"===START==");
		ITestListener.super.onTestStart(result);
	}
 @Override
	public void onTestSuccess(ITestResult result) {
	 Reporter.log("=================="+result.getMethod().getMethodName()+"==End===");
	 test.log(Status.PASS, result.getMethod().getMethodName()+"===COMPLETED==");
		ITestListener.super.onTestSuccess(result);
	}
 @Override
	public void onTestFailure(ITestResult result) {
	 String testName=result.getMethod().getMethodName();
		TakesScreenshot ts= (TakesScreenshot) BaseClass.sdriver;
	    String filePath = ts.getScreenshotAs(OutputType.BASE64);
	    String timestamp = LocalDateTime.now().toString().replace(" ", "_").replace(":", "_"); //capture system date and time
	  test.addScreenCaptureFromBase64String(filePath, testName+"_"+timestamp);
	 Reporter.log("=================="+result.getMethod().getMethodName()+"=====");
	 test.log(Status.FAIL, result.getMethod().getMethodName()+"===fAIL==");
		ITestListener.super.onTestFailure(result);
	}
 @Override
		public void onTestSkipped(ITestResult result) {
	 test.log(Status.INFO, result.getMethod().getMethodName()+"===SKIPPED==");
			ITestListener.super.onTestSkipped(result);
		}
 

}
