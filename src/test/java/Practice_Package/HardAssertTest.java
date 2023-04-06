package Practice_Package;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

public class HardAssertTest {
	@Test
public void test1()
{
	System.out.println("=======TestScript1=====");
	System.out.println("=======TestScript1=====");
	assertEquals("testyantra", "qspider");
	System.out.println("=======TestScript1=====");
}
	@Test
public void test2()
{
	int i=10;
	System.out.println("=======TestScript4=====");
	System.out.println("=======TestScript5=====");
	assertNull(i);
	System.out.println("=======TestScript6=====");
}
}
