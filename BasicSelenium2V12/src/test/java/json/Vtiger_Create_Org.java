package json;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Vtiger_Create_Org {
	@Test
	public void seleniumTest() throws IOException, ParseException, InterruptedException{
		//step1:parse JSON Physical file in to java OBJect using JSONParse Class
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\sneha\\Desktop\\appCommonData.json"));
		
		//step2:parse java object in to JSONObject using downcasting
		JSONObject map=(JSONObject)obj;
		
		String URL = map.get("url").toString();
		String BROWSER = map.get("browser").toString();
		String USERNAME = map.get("username").toString();
		String PASSWORD = map.get("password").toString();
		
		//generate random number
		Random random=new Random();
		int randomInt=random.nextInt(1000);
		
		//read testScript data from Excel file
		FileInputStream fis=new FileInputStream("./src/test/resources/td/Data.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("sheet1");
		Row row = sh.getRow(1);
		String orgName = row.getCell(0).toString()+randomInt;
		wb.close();
		
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
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		Thread.sleep(3000);
		driver.findElement(By.name("button")).click();
		driver.quit();
	}
	}
