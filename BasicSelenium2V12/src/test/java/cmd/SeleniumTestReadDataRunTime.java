package cmd;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.reactivex.rxjava3.internal.operators.single.SingleFromUnsafeSource;

public class SeleniumTestReadDataRunTime {
@Test
public void seleniumTest() throws IOException{
	
//read common data from CMD line
	
	String URL = System.getProperty("url");
	System.out.println("ENV DATA==>URL============>"+URL);
	String BROWSER = System.getProperty("browser");
	System.out.println("BROWSERL DATA==>BROWSER============>"+BROWSER);
	String USERNAME = System.getProperty("username");
	System.out.println("USERNAM DATA==>USERNAME============>"+USERNAME);
	String PASSWORD = System.getProperty("password");
	System.out.println("PASSWORD DATA==>PASSWORD============>"+PASSWORD);
	
	//generate random number
	Random random=new Random();
	int randomInt=random.nextInt(1000);
	
	//read testScript data from Excel file
	FileInputStream fis=new FileInputStream("C:\\Users\\sneha\\Desktop\\data\\testData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("sheet1");
	Row row = sh.getRow(1);
	String orgName = row.getCell(2).toString()+randomInt;
	wb.close();
	WebDriver driver=null;
	
	if (BROWSER.equals("chrome")) {
		driver=new ChromeDriver();
	                              }
	else if(BROWSER.equals("firefox")) {
		driver=new FirefoxDriver();
	}
	else if(BROWSER.equals("edge")) {
		driver=new EdgeDriver();
	}
	else {
		driver=new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD );
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	driver.findElement(By.xpath("//img[contains(@title,'Create Organization')]")).click();
	driver.findElement(By.name("accountname")).sendKeys("RajuChaCha");
	driver.findElement(By.name("button")).click();
	driver.quit();
}
}
