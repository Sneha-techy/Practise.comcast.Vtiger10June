package com.comcast.crm.generic.webdriverutility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Java_Utility_2 {

    /**
     * Generate a random number up to 5000
     */
    public int getRandomNumber() {
        Random ranDom = new Random();
        return ranDom.nextInt(5000);
    }

    /**
     * Get current system date in yyyy-MM-dd format
     */
    public String getSystemDateYYYYMMDD() {
        Date dateObj = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dateObj);
    }

    /**
     * Get current system date in dd-MM-yyyy format
     */
    public String getSystemDateDDMMYYYY() {
        Date dateObj = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(dateObj);
    }

    /**
     * Get required date after adding days (future date) in yyyy-MM-dd format
     */
    public String getFutureDateYYYYMMDD(int daysToAdd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, daysToAdd);
        return sdf.format(cal.getTime());
    }

    /**
     * Get required date before subtracting days (past date) in yyyy-MM-dd format
     */
    public String getPastDateYYYYMMDD(int daysToSubtract) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -daysToSubtract);
        return sdf.format(cal.getTime());
    }

    /**
     * Get timestamp (useful for filenames or logging)
     */
    public String getTimeStamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return sdf.format(date);
    }
}