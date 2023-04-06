package Practice_Package;

import org.testng.annotations.Test;

public class Testscript_1Test {
@Test
	public void create()
	{
		System.out.println("---create data");
	}
@Test(invocationCount=2 , dependsOnMethods="create")
	public void edit()
	{
		System.out.println("---data edited");
	}
@Test(priority=-1)
	public void delete()
	{
		System.out.println("---data deleted");
	}
	
}
