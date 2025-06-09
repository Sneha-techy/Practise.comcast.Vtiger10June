package actionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickAndHold {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		Thread.sleep(2000);
		//create an object of Actions Class
		Actions action =new Actions(driver);
      WebElement source = driver.findElement(By.id("box3"));
      WebElement target = driver.findElement(By.id("box103"));
        action.scrollByAmount(0, 300);
		action.clickAndHold(source).moveToElement(target).click().perform();
		
		//2nd drag and drop
		 WebElement source1 = driver.findElement(By.id("box5"));
	      WebElement target1 = driver.findElement(By.id("box105"));
	      //action.scrollByAmount(0, 300);
	      action.clickAndHold(source1).moveToElement(target1).click().perform();
		
	  	//3nd drag and drop
			 WebElement source2 = driver.findElement(By.id("box1"));
		      WebElement target2= driver.findElement(By.id("box101"));
		      //action.scrollByAmount(0, 300);
		      action.clickAndHold(source2).moveToElement(target2).click().perform();
		
}
}