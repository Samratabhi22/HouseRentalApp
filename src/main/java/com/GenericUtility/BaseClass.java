package com.GenericUtility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ObjectRepo.DashBoardPagePage;
import com.ObjectRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
		public FileUtility fLib =new FileUtility();
		public ExcelUtility eLib =new ExcelUtility();
		public DatabaseUtility dLib = new DatabaseUtility();
		public WebDriverUtility wLib =new WebDriverUtility();
		public JavaUtility jLib =new JavaUtility();
		public WebDriver driver;
		public static WebDriver sdriver;
		
		@BeforeSuite(alwaysRun = true)
		public void configBS() throws Throwable
		{
			//dLib.connectToDb();
			System.out.println("connection success");
			
		}
		
		//@Parameters("BROWSER")
		@BeforeClass(alwaysRun = true)
		//public void configBC(String BROWSER) throws Throwable
		public void configBC() throws Throwable
		{
			String BROWSER = fLib.readDataFromPropertyFile("browser");
			System.out.println(BROWSER);
			String URL = fLib.readDataFromPropertyFile("url");
			
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver =new EdgeDriver();
			}
			else
			{
				System.out.println("Invalid browser");
			}
			sdriver=driver;
			wLib.maximizeWindow(driver);
			driver.get(URL);
			wLib.waitForPageLoad(driver);
			System.out.println("browser opening successful");
		}
		
		
		@BeforeMethod(alwaysRun = true)
		public void configBM() throws Throwable
		{
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
			LoginPage lp =new LoginPage(driver);
			lp.loginPage(USERNAME, PASSWORD);
			System.out.println("login successful");
		}
		@AfterMethod(alwaysRun = true)
		public void configAM()
		{
			DashBoardPagePage dp = new DashBoardPagePage(driver);
			dp.clickLogout();
			System.out.println("logout successful");
		}
		@AfterClass(alwaysRun = true)
		public void configAC()
		{
			driver.quit();
			System.out.println("browser closing success");
		}
		
		@AfterSuite(alwaysRun = true)
		public void configAS() throws Throwable
		{
			//dLib.closeDB();
			System.out.println("DB closed successfully");
		}
		
	}


