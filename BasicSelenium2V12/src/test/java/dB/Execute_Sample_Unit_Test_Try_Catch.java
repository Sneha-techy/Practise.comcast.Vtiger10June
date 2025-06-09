package dB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Execute_Sample_Unit_Test_Try_Catch {
public static void main(String[] args) throws Throwable {
		Connection conn=null;
		try {
		//step1:load/register the database driver
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);//static method
		
		//step2: connect to database
	
	                  conn= DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
	System.out.println("==========>Done============");
	
		//step3:Create SQL Statement
	    Statement stat = conn.createStatement();
	    		
		//step4:execute select query & get result
	    		ResultSet resultset = stat.executeQuery("select* from project123");
	    	while	(resultset .next()) 
	    	{
	    		System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4)+"\t"+resultset.getString(5)+"\t"+resultset.getString(6));
	    	}
		}
		catch(Exception e) 
		{
			System.out.println("handle exception");
		}
		finally
		{
		//step5:close the connection
	    		conn.close();
	    		System.out.println("===================close the connection");
	}
}
}