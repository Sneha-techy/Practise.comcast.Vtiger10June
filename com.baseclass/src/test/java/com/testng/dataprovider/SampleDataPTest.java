package com.testng.dataprovider;

import org.testng.annotations.DataProvider;

public class SampleDataPTest {
	@DataProvider
	public Object[][] getData1() {
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


		@DataProvider
		public Object[][] getData2() {
			Object[][] objArr=new Object[3][3];
			objArr[0][0]="Ram";
			objArr[0][1]="PA";
			objArr[0][2]=9876543211l;
			
			objArr[1][0]="snehaKKK";
			objArr[1][1]="QA test Engg";
			objArr[1][2]=8876543211l;
			
			objArr[2][0]="DingiSSS";
			objArr[2][1]="Full SDET ";
			objArr[2][2]=7876543211l;
			
			return objArr;
			
			
		}
	}

