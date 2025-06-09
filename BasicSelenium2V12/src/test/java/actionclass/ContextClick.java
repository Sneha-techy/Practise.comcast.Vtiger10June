package actionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClick {
	
		public static void main(String[] args) throws InterruptedException {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("https://demo.guru99.com/test/simple_context_menu.html");
			
			Actions action =new Actions(driver);
			//right click button
		WebElement rightbtn = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		action.contextClick(rightbtn).build().perform();
		
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Copy']"))).click().perform();
			
}
}