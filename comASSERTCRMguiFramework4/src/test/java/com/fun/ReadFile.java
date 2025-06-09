package com.fun;

import org.testng.annotations.Test;

import com.cast.crm.generic.fileutility.ExcelUtility;


	public class ReadFile {
		@Test
		public void createReadFile() throws Throwable {
	ExcelUtility ref=new ExcelUtility();
	ref.getRowcount("iphone");
	ref.setDataIntoExcel("iphone",5,2,"Timepass");
	ref.getDataFromExcel("iphone", 2,1);
}
}