package Practice_Package;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
@DataProvider()
	public Object[][] getDetails()
	{
	Object [][] obj = new Object[2][3];
	obj[0][0]="Qspider";
	obj[0][1]="institue";
	obj[0][2]="bangalore";
	
	obj[1][0]="Sony";
	obj[1][1]="companydetails";
	obj[1][2]="Mumbai";
			
		return obj;
	}
@Test(dataProvider ="getDetails")
public void  company(String data, String value, String output)
{
	Reporter.log("company---> "+data+"details--->"+value+"position--->"+output);
}
	
}
