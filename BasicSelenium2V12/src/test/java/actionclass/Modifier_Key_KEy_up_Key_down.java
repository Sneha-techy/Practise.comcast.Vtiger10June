package actionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Modifier_Key_KEy_up_Key_down {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		Actions action =new Actions(driver);
		WebElement searchTxtFld = driver.findElement(By.id("small-searchterms"));
		action.moveToElement(searchTxtFld).click().keyDown(Keys.SHIFT).sendKeys("mobiles").keyUp(Keys.SHIFT).perform();
		
}
}