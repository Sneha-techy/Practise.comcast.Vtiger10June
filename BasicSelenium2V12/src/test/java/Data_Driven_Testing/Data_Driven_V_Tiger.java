package Data_Driven_Testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Data_Driven_V_Tiger {
	public static void main(String[] args) throws IOException {
		//step1:get the java representation object of the physical file
		FileInputStream fis =new FileInputStream("C:\\Users\\sneha\\Desktop\\vTigerCommonData.properties");
		
		
		
		//step2:using Properties class,load all the keys
		Properties prop=new Properties();
		prop.load(fis);
		
		
		//step3:get the value based on Key
		
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		
		
	}

}
