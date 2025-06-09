package com.comcast.crm.generic.webdriverutility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
public int getRandomNumber()
{
	Random ranDom=new Random();
	int ranDomNumber=ranDom.nextInt(5000);
	return ranDomNumber;
}
public String getSystemDateYYYYDDMM() {
	Date dateObj=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	String date = sdf.format(dateObj);
	System.out.println("Actual Date:"+date);
	return date;
	
}
public String getRequiredDateYYYYDDMM(int days) 
{
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal = sim.getCalendar();
    cal.add(Calendar.DAY_OF_MONTH, days);
    String reqDate = sim.format(cal.getTime());
    
	System.out.println("Before Date:"+reqDate );
	return reqDate;
}
	
	
	public String getStartDateYYYYMMDD() {
		Date dateObj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String stdate = sdf.format(dateObj);
		System.out.println("Start_Date:"+stdate);
		return stdate;
		
	}
	public String getEndDateYYYYMMDD(int days) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Calendar cal = Calendar.getInstance(); //Proper calendar object
	    cal.add(Calendar.DAY_OF_MONTH, days); //Add the passed 'days' value
	    String endDate = sdf.format(cal.getTime());
	    System.out.println("End_Date: " + endDate);
	    return endDate;
	}
}
