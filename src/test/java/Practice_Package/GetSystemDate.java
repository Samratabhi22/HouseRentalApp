package Practice_Package;

import java.util.Date;

public class GetSystemDate {

	public static void main(String[] args) {
	Date date = new Date();
		String dateAndTime = date.toString();
		System.out.println(dateAndTime);
		
		String []d=dateAndTime.toString().split(" ");
		
		  String day= d[0];
		   String month= d[1];
			String dd = d[2];
			String year = d[5];
           System.out.println(day+" "+month+" "+dd+" "+year);
          
           
		
				

	}

}
//Sat Mar 18 12:39:29 IST 2023