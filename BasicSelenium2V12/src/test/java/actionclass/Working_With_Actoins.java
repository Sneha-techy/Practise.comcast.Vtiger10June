package actionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_With_Actoins {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		
		//create an object of Actions Class
		Actions action =new Actions(driver);
		//move to element 
		WebElement computers = driver.findElement(By.xpath("//a[contains(text(),'Computers')]"));
		action.moveToElement(computers).click().build().perform();
		
		WebElement desktop = driver.findElement(By.xpath("//ul[@class='sublist firstLevel']/descendant::a[contains(text(),'Desktops')]"));
		action.moveToElement(desktop).click().build().perform();
		
}
}
