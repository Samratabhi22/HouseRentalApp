package Practice_Package;

import org.testng.annotations.Test;

public class DP_Test {
@Test(dataProviderClass = DataPro.class, dataProvider="getDetails" )
	public void getEmpDetails(int data, String value)
	{
		System.out.println("EmpID---->"+data+"EmpNAme--->"+value);
	}
}
