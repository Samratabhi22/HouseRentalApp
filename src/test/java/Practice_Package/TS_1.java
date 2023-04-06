package Practice_Package;

import org.testng.annotations.Test;

public class TS_1 {
	@Test(groups="smoke")
public void script1()
{
	System.out.println("==execute script 1==");
}
	@Test(groups="regression")
public void script2()
{
	System.out.println("==execute script 2==");
}
}
