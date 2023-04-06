package com.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method is used for using random number
	 * @return
	 * @author Abhishek
	 */
public int randomNum()
{
	Random ran = new Random();
	int random = ran.nextInt(100);
	return random;
	
}
/**
 * This method is used for taking system date
 * @return
 * @author Abhishek
 */
public String getSystemDate()
{
	Date dt = new Date();
	String date = dt.toString();
	return date;
}
/**This method is used for format the data
 * 
 * @return
 * @author Abhishek
 */
public String formatSystemDate()
{
SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
Date dt = new Date();
String getDateAndTime = dateformat.format(dt);
getDateAndTime.replace(":", "-");
return getDateAndTime;

}
}
