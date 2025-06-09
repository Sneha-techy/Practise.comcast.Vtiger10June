package mock;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class DemoWebShop_TakeScreenShort {
public static void main(String[] args) throws IOException, InterruptedException {
	String timestamp = LocalDateTime.now().toString().replace(":", "_");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	
	driver.get("https://demowebshop.tricentis.com/");
	driver.findElement(By.partialLinkText("Electronics")).click();
	driver.findElement(By.xpath("(//a[contains(@title,'Show products in category Cell phones')])[1]")).click();
	driver.findElement(By.xpath("//a[text()='Smartphone']/../.././/input[@type='button']")).click();
	Thread.sleep(2000);
	TakesScreenshot ts= (TakesScreenshot) driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("./SSK/_kart_add"+timestamp+".png");
   FileHandler.copy(temp,dest);
		
	File temp1 = driver.findElement(By.xpath("//p[contains(text(),'The product has been added to your')]")).getScreenshotAs(OutputType.FILE);
    File dest1=new File("./SSK/_kart1_add"+timestamp+".png");
	FileHandler.copy(temp1,dest1);
}
}
