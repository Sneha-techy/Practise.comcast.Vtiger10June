package dB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleUnitTestCheckProjectInBackEnd {
@Test
public void projectChecktest() throws SQLException 

{
	String expectedProjectName = "FB51";
	boolean flag=false;
		//step1:load/register the database driver
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
	    	 if (expectedProjectName.equals(actProjectName))
	    	 {
	    		 flag=true;
	    		 System.out.println(expectedProjectName +"is available==Pass");
	    	 }
	    	}
	    	if(flag==false)
	    	{
	    		System.out.println(expectedProjectName+"is not  available==Fail");
	    		Assert.fail();
	    	}


		//step5:close the connection
	    		conn.close();
	
}
}



