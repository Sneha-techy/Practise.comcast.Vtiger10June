package dB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Execute_Non_Select_Query {
public static void main(String[] args) throws Throwable {
		
		//step1:load/register the database driver
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);//static method
		
		//step2: connect to database
	//Connection	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");//sirs
	                  Connection conn= DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
	System.out.println("==========>Done============");
	
		//step3:Create SQL Statement
	    Statement stat = conn.createStatement();
	    		
		//step4:execute select query & get result
	    		 int result = stat.executeUpdate("  insert into project values('TY_RPOJ_1928','SNEHA11','16/05/2025','FB5','Created','101')");
	    		System.out.println(result);
	    
	    		
		//step5:close the connection
	    		conn.close();
	}
}
	
