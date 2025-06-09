package com.testng.dataprovider;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_With_PhoneNum_Test2 {
@Test(dataProvider ="getData")
public void createContactTest(String firstName,String lastName) {
	Reporter.log("FirstName:"+firstName+",LastName:"+lastName);
}
@DataProvider
public Object[][] getData() {
	Object[][] objArr=new Object[3][2];
	objArr[0][0]="deepak";
	objArr[0][1]="hr";
	
	objArr[1][0]="sneha";
	objArr[1][1]="QA test Engg";
	
	objArr[2][0]="Dingi";
	objArr[2][1]="Full SDET ";
	
	return objArr;
	
	
}
}


