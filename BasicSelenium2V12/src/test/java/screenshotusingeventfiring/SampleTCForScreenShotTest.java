package screenshotusingeventfiring;

import java.io.File;
import java.io.IOException;

import org.apache.commons.collections4.FactoryUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTCForScreenShotTest {
@Test
public void amazonTest() throws IOException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in");
	//step1 create an Object to EventFiring Webdriver
	EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
	//step2:use getScreenshots method to get file type of screenshot
    File srcFile = edriver.getScreenshotAs(OutputType.FILE);
    
    //Store screen on local driver
   // FileUtils.copyFile(srcFile, new File("./screenshot/test11.png"));
    FileUtils.copyFile(srcFile, new File("‪C/Users/sneha/Desktop/ss/Test.png"));
    System.out.println("Done");
    driver.quit();

}
}
