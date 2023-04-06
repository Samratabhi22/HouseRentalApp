package com.GenericUtility;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * This method is used to return random number
	 * @return
	 * @author panth
	 */
	public int random()
	{
		Random ran =new Random();
		int random = ran.nextInt();
		return random; 
	}
	
	/**
	 * This method is used to return the 2digit random number
	 * @return
	 */
	public int randomTwo()
	{
		Random ran =new Random();
		int random =ran.nextInt(100);
		return random;
	}
	
	public int randomFive()
	{
		Random ran = new Random();
		int random = ran.nextInt(100000);
		return random;
	}
	
	
	/**
	 * This method is used to return the systemDate
	 * @return
	 */
	public String getSystemDate()
	{
		Date dt= new Date();
		String date =dt.toString();
		return date;
	}
	
	/**
	 * This method is used to return the systemDateformat
	 * @return
	 */
	public String formatSystemDate()
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date dt= new Date();
		String getDateAndTime =dateformat.format(dt);
		return getDateAndTime;
		
	}

}
