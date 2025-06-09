package autosuggesstiondropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart_AutoSugesstion {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.name("q")).sendKeys("puma");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[contains(text(),'puma')])[1]")).click();
	}
}