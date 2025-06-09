package actionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Doubleclick {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		//driver.get("https://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
		//create an object of Actions Class
		Actions action =new Actions(driver);
		//double click button
	WebElement doublebtn = driver.findElement(By.xpath("//button[contains(text(),'Click Me ')]"));
	action.doubleClick(doublebtn).build().perform();
	
	
}
}