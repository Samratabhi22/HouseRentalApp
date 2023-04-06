package Practice_Package;

import org.testng.annotations.Test;

public class TS_2 {
	@Test(groups={"smoke","regression"})
public void script3()
{
	System.out.println("==execute script 3==");
}
	@Test(groups= {"smoke","regression"})
public void script4()
{
	System.out.println("==execute script 4==");
}
}
