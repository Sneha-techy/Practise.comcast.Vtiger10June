package tc.practice;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
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
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.Test;

	public class Create_Contact_Industry_Type_2 {
		@Test
		public void orgWith_IndustryAdType() throws FileNotFoundException, IOException, ParseException
		{
			// to Read commonData from Json
					JSONParser jp = new JSONParser();
					Object obj = jp.parse(new FileReader("C:\\Users\\sneha\\Desktop\\data\\appCommonData.json"));
					JSONObject jobj=(JSONObject)obj;
					String browser = jobj.get("Browser").toString();
					String url = jobj.get("Url").toString();
					String username = jobj.get("Username").toString();
					String password = jobj.get("Password").toString();
					
					//TO create random Numbers
					Random rom = new Random();
					int randomNumber = rom.nextInt(1000);

					//To read TestScript Data From Excel
					FileInputStream fis = new FileInputStream("./src/test/resources/td/Daata.xls");
					Workbook workbook = WorkbookFactory.create(fis);
					Sheet sh = workbook.getSheet("Sheet1");
					Row row = sh.getRow(4);
					String orgName = row.getCell(2).toString()+randomNumber;
					String industry = row.getCell(3).toString();

					String type = row.getCell(4).toString();

				
					//To launch browser based on commondata
					WebDriver driver;
					if(browser.contains("chrome"))
					{
						 driver= new ChromeDriver();
					}else if(browser.contains("firefox"))
					{
						 driver= new FirefoxDriver();
					}else if(browser.contains("edge"))
					{
						 driver= new EdgeDriver();
					}else
					{
						driver= new ChromeDriver();
					}
					
					 //Navigate to the application
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
					driver.get(url);
					
					//Login to Application
						driver.findElement(By.name("user_name")).sendKeys(username);
						driver.findElement(By.name("user_password")).sendKeys(password);
						driver.findElement(By.id("submitButton")).click();
						
						driver.findElement(By.linkText("Organizations")).click();
						driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
						driver.findElement(By.name("accountname")).sendKeys(orgName);
						//Select industry and type
						WebElement industrySel=driver.findElement(By.name("industry"));
						WebElement typeSel=driver.findElement(By.name("accounttype"));
						Select sel= new Select(industrySel);
						sel.selectByValue(industry);
						Select sel1= new Select(typeSel);
						sel1.selectByValue(type);
						driver.findElement(By.name("button")).click();
						String actualIndustryName = driver.findElement(By.id("dtlview_Industry")).getText();
						if(actualIndustryName.equals(industry))
						{
							System.out.println(industry+" is Selected successfully==== PASS");
						}
						else
						{
							System.out.println(orgName+" is not selected successfully==== Fail");
						}
						String actualType = driver.findElement(By.id("dtlview_Type")).getText();

						if(actualType.equals(type))
						{
							System.out.println(type+" is Selected successfully==== PASS");
						}
						else
						{
							System.out.println(orgName+" is not selected successfully==== Fail;");
						}
						
						//Logout Action
						driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
						driver.findElement(By.linkText("Sign Out")).click();
						driver.quit();
				}
		}