package com.cast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.protobuf.TextFormat.ParseException;

public class JsonUtility {
public String getDataFromJsonFile(String key) throws Throwable,ParseException {
	FileReader fileR=new FileReader("./configAppData/appCommonData.json");
	JSONParser par=new JSONParser();
	Object obj = par.parse(fileR);
	JSONObject map=(JSONObject) obj;
	String data = (String) map.get(key);
	return data;
}
}
