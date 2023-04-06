package Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtilities.ExcelUtility;

public class DataProv {
	@Test(dataProvider = "readSetofData")
	public void getData(String src , String dst)
	
	{
		System.out.println("From--->"+src+"to--->"+dst);
	}
	@DataProvider
	public Object[][] readSetofData() throws Throwable
	{
		ExcelUtility eib = new ExcelUtility();
		Object[][] value = eib.readMultipleSetofData("DP");
		return value;
	}

}
