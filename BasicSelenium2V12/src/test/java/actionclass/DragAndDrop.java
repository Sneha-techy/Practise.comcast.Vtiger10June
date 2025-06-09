package actionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		//create an object of Actions Class
		Actions action =new Actions(driver);
		WebElement source = driver.findElement(By.id("box3"));
		
		//Target WebElement
		
		WebElement target = driver.findElement(By.id("box103"));
		action.scrollByAmount(0, 300);
		Thread.sleep(5000);
		action.dragAndDrop(source, target).build().perform();
		
//2nd drag drop
		WebElement source1 = driver.findElement(By.id("box6"));
		
		//Target WebElement
		
		WebElement target1 = driver.findElement(By.id("box106"));


		Thread.sleep(5000);
		action.dragAndDrop(source1, target1).build().perform();
		
		 
		
}
}