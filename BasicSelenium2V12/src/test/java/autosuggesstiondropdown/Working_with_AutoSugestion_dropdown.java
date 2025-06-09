package autosuggesstiondropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_with_AutoSugestion_dropdown {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demowebshop.tricentis.com/");
	Thread.sleep(2000);
	driver.findElement(By.id("small-searchterms")).sendKeys("compu");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[contains(text(),'Build your own computer')]")).click();
}
}
