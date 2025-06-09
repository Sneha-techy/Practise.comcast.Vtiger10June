package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTest {
public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	//step1:parse JSON Physical file in to java OBJect using JSONParse Class
	JSONParser parser=new JSONParser();
	Object obj = parser.parse(new FileReader("C:\\Users\\sneha\\Desktop\\appCommonData.json"));
	
	//step2:parse java object in to JSONObject using downcasting
	JSONObject map=(JSONObject)obj;
	
	//step3:get the value from json file using key
	System.out.println(map.get("url"));
	System.out.println(map.get("browser"));
	System.out.println(map.get("username"));
	System.out.println(map.get("password"));
	System.out.println(map.get("timeout"));
	
}
}


	
	
