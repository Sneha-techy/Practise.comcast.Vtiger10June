package SelectClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		//click on book
		driver.findElement(By.partialLinkText("Books")).click();
		Thread.sleep(1000);
		
		//sortby dropdown
		 WebElement sort = driver.findElement(By.id("products-orderby"));
		 Select objsel=new Select(sort);
		 objsel.selectByVisibleText("Price: Low to High");
		 Thread.sleep(1000);
		
		 //Displays dropdown
		 WebElement sort1 = driver.findElement(By.id("products-pagesize"));
		 Select objsel1=new Select(sort1);
		 
		 objsel1.selectByVisibleText("4");
		 Thread.sleep(1000);
		 // View as dropdown
		 WebElement sort2 = driver.findElement(By.id("products-viewmode"));
		 Select objsel2=new Select(sort2);
		 
		 objsel2.selectByIndex(1);
}
}