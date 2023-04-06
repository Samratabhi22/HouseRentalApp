package Practice_Package;

import org.testng.annotations.DataProvider;

public class DataPro {
	@DataProvider()
public Object[] [] getDetails()
{
	Object[] [] obj = new Object[2] [2];
	obj[0][0]=101;
	obj[0][1]="Abhishek";
	
	obj[1][0]=102;
	obj[1][1]="Raja";
	return obj;
	
}
}
