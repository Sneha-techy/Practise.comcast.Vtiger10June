package com.testng.dataprovider;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_test {
@Test(dataProvider ="getData")
public void createContactTest(String firstName,String lastName,long phoneNumber) {
	System.out.println(("FirstName:"+firstName+",LastName:"+lastName+",phoneNumber:"+phoneNumber));
}
@DataProvider
public Object[][] getData() {
	Object[][] objArr=new Object[3][3];
	objArr[0][0]="deepak";
	objArr[0][1]="hr";
	objArr[0][2]=9876543211l;
	
	objArr[1][0]="sneha";
	objArr[1][1]="QA test Engg";
	objArr[1][2]=8876543211l;
	
	objArr[2][0]="Dingi";
	objArr[2][1]="Full SDET ";
	objArr[2][2]=7876543211l;
	
	return objArr;
	
	
}
}


