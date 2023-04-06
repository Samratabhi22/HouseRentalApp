package Practice_Package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationTest {
@BeforeSuite
	public void databaseConnection()
	{
		System.out.println("DB connection established");
	}
@BeforeClass
public void openBrowser()
{
	System.out.println("Open the browser");
}
@BeforeMethod
public void loginToApp()
{
	System.out.println("login to the application");
}
@Test
public void testScript_1()
{
	System.out.println("testScript_1 executed");
}
@Test
public void testScript_2()
{
	System.out.println("testScript_2 executed");
}
@AfterMethod
public void logoutToApp()
{
	System.out.println("Logout of the Application");
}
@AfterClass
public void closeBrowser()
{
System.out.println("closing the browser");
}
@AfterSuite
public void closeDBconnection()
{
	System.out.println("db connection closed");
}
}

