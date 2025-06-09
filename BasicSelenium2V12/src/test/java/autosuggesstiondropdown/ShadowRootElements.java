package autosuggesstiondropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ShadowRootElements {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		Thread.sleep(2000);
		driver.findElement(By.xpath(" //section[contains(text(),'Shadow Root ')]")).click();

		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//section[contains(text(),'Shadow ')])[2]")).click();
		Thread.sleep(2000);

		
		//shadow host username							
		SearchContext shadowHost = driver.findElement(By.xpath("//form/div[1]")).getShadowRoot();
		shadowHost.findElement(By.cssSelector("input[type='text']")).sendKeys("Sneha");
		//shadow host password
		Thread.sleep(2000);

		SearchContext shadowHostPassword = driver.findElement(By.xpath("//form/div[2]")).getShadowRoot();
		shadowHostPassword.findElement(By.cssSelector("input[type='text']")).sendKeys("Sneha@1234");
		
}
}
