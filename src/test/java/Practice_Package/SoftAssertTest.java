package Practice_Package;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	SoftAssert	sa= new SoftAssert();
	@Test
public void test1()
{
	Reporter.log("=======TestScript1=====", true);
	Reporter.log("=======TestScript2=====", true);
	sa.assertEquals("testyantra", "qspider");
	Reporter.log("=======TestScript3=====", true);
	sa.assertAll();
	
}
@Test
public void test2()
{int i=10;
	Reporter.log("=======TestScript4=====", true);
	Reporter.log("=======TestScript5=====", true);
	sa.assertNull(i);
	Reporter.log("=======TestScript6=====", true);
	sa.assertAll();
}
}
