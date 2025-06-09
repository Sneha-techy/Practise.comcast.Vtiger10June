package com.testng.dataprovider;

import org.testng.annotations.Test;

public class SampleTest {
	@Test(dataProviderClass=SampleDataPTest.class,dataProvider ="getData2")
	public void createContactTest(String firstName,String lastName,long phoneNumber) {
		System.out.println(("FirstName:"+firstName+",LastName:"+lastName+",phoneNumber:"+phoneNumber));
	}
	}