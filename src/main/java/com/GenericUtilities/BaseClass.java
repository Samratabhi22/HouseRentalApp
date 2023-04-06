package com.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ObjectRepository.HomePage;
import com.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public DatabaseUtility dib = new DatabaseUtility();
	public FileUtility fib= new FileUtility();
	public ExcelUtility eib= new ExcelUtility();
	public WebDriverUtility wib= new WebDriverUtility();
	public WebDriver driver;
@BeforeSuite
public void configBS() throws Throwable
{
//	dib.connectToDb();
//	System.out.println("--connect to DB--");
}
@BeforeClass
public void configBC() throws Throwable
{
	String BROWSER=fib.readDataFromPropertyFile("browser");
	String URL=fib.readDataFromPropertyFile("url");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{	
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
		
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.chromedriver().setup();
		driver= new FirefoxDriver();
	}
	else
	{
		System.out.println("--INVALID BROWSER--");
	}
	wib.maximizeWindow(driver);
	driver.get(URL);
	wib.waitForPageLoad(driver);
}
@BeforeMethod
public void configBM() throws Throwable
{
	String USERNAME = fib.readDataFromPropertyFile("username");
String PASSWORD = fib.readDataFromPropertyFile("password");
LoginPage lp = new LoginPage(driver);
//lp.loginLink(driver);
lp.loginPage(USERNAME, PASSWORD);
	
}
@AfterMethod
public void configAM()
{
	HomePage hp = new HomePage(driver);
	hp.logoutBtn(driver);
}
@AfterClass
public void configAC()
{
	driver.quit();
}
@AfterSuite
public void configAS() throws Throwable
{
	dib.closeDB();
}

}
