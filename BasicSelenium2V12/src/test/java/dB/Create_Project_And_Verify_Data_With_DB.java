package dB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mysql.cj.jdbc.Driver;

public class Create_Project_And_Verify_Data_With_DB {
public static void main(String[] args) throws SQLException {
	
	//create project in GUI
	String projectName ="Instagram_01";
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://49.249.28.218:8091");
	
	driver.findElement(By.id("username")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	
	driver.findElement(By.linkText("Projects")).click();
	driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	
	driver.findElement(By.name("projectName")).sendKeys(projectName);
	driver.findElement(By.name("createdBy")).sendKeys("SNEHA");
	
	Select sel=new  Select(driver.findElement(By.name("status")));
	
	sel.selectByIndex(0);
	driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	
	//verify the project in db
	//step1:load/register the database driver
	boolean flag=false;
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);//static method
			
			//step2: connect to database
			Connection conn= DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		    System.out.println("==========>Done============");
		
			//step3:Create SQL Statement
		    Statement stat = conn.createStatement();
		    		
			//step4:execute select query & get result
		    		ResultSet resultset = stat.executeQuery("select* from project");
		    	while	(resultset .next())
		    	{
		    	 String actProjectName	=resultset.getString(4);
		    	 if (projectName.equals(actProjectName))
		    	 {
		    		 flag=true;
		    		 System.out.println(projectName +"is available==Pass");
		    	 }
		    	}
		    	if(flag==false)
		    	{
		    		System.out.println(projectName+"is not  available==Fail");
		    		Assert.fail();
		    	}


			//step5:close the connection
		    		conn.close();
		
	
}
}
