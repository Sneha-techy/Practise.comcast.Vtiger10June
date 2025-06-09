package Data_Driven_Testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Create_Data_Driven_Testing_V_Tiger {
	public static void main(String[] args) throws IOException {
		
	
	//step1:get the java representation object of the physical file
			FileInputStream fis =new FileInputStream("C:\\Users\\sneha\\Desktop\\vTigerCommonData.properties");
			
			//step2:using Properties class,load all the keys
			Properties prop=new Properties();
			prop.load(fis);
			
			//step3:get the value based on Key
			
			String BROWSER = prop.getProperty("browser");
			String URL = prop.getProperty("url");
			String USERNAME = prop.getProperty("username");
			String PASSWORD = prop.getProperty("password");
			WebDriver driver=null;
			if (BROWSER.equals("chrome")) {
				driver=new ChromeDriver();
			                              }
			else if(BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
			}
			else if(BROWSER.equals("edge")) {
				driver=new EdgeDriver();
			}
			else {
				driver=new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD );
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
			driver.findElement(By.xpath("//img[contains(@title,'Create Organization')]")).click();
			driver.findElement(By.name("accountname")).sendKeys("RajuChaCha");
			driver.findElement(By.name("button")).click();
			driver.findElement(By.className("dvHeaderText")).click();
			//driver.quit();class="dvHeaderText"
			
			
			
			
}
}