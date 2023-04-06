package Register_Package;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.ObjectRepository.ApartmentRegistrationPage;
import com.ObjectRepository.Details_UpdatePage;
import com.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.ObjectRepository.HomePage;


public class RegistrationOfAPARTMENT extends BaseClass{
	
	
	
	@Test
	public void regn_Apt() throws Throwable
	{
		LoginPage lp = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		ApartmentRegistrationPage arp = new ApartmentRegistrationPage(driver);
		//Details_UpdatePage du= new Details_UpdatePage(driver);
		
		
		home.registerLink(driver);
		arp.Apartment_Registration_tab(driver);
		HashMap <String , String> map = eib.readMultipleData("Sheet4");
		arp.apartmentdetails(driver, map);
		arp.addMore(driver);
		HashMap<String , String> maps = eib.readMultipleData("Sheet8");
		arp.apartmentMoreDetails(maps, driver);
		System.out.println(maps);
//		HashMap<String , String> maks = eib.readMultipleData("Sheet9");
//		arp.allDropDown(maks, driver, wib);
		arp.Submit_Btn(driver);
		arp.registrationApartment_sucessful(driver);
	}
}

		
//	FileUtility fib = new FileUtility();
//	JavaUtility jib = new JavaUtility();
//	DatabaseUtility dib = new DatabaseUtility();
//	WebDriverUtility wib = new WebDriverUtility();
//	ExcelUtility eib= new ExcelUtility();
//	WebDriverManager.chromedriver().setup();
//	WebDriver driver = new ChromeDriver();
//	wib.maximizeWindow(driver);
//	wib.waitForPageLoad(driver);
//	String Url = fib.readDataFromPropertyFile("url");
//	String USERNAME = fib.readDataFromPropertyFile("username");
//	String PASSWORD = fib.readDataFromPropertyFile("password");

//	
	
	
	
	//Login to Application
//	driver.get(Url);
//	wib.waitForPageLoad(driver);
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.findElement(By.xpath("//a[.='Login']")).click();
	//lp.loginLink(driver);
	//lp.loginPage(USERNAME, PASSWORD);
//	driver.findElement(By.name("username")).sendKeys(USERNAME);
//	driver.findElement(By.name("password")).sendKeys(PASSWORD);
//	driver.findElement(By.xpath("//button[@type='submit']")).click();
	//register module
	
	//driver.findElement(By.linkText("Register")).click();
	
	//driver.findElement(By.linkText("Apartment Registration")).click();
	//Filling the first part of details in Apartment registration
	
//	for (Entry<String, String> set : map.entrySet()) {
//		
//		driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='"+set.getKey()+"']")).sendKeys(set.getValue());
//
//	}
	//clicking on add more button in Apartment Registration page
	
	//driver.findElement(By.cssSelector(".btn.btn-info.btn-sm")).click();
	
	//Filling the second part of details
	
//	for (Entry<String, String> sets : maps.entrySet()) {
//		
//		driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@name='"+sets.getKey()+"']")).sendKeys(sets.getValue());
//
//	}
	
	//driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='description']")).sendKeys("Hi");
//	WebElement purpos = driver.findElement(By.xpath("//select[@id='purpose']"));
//	wib.select("Commercial", purpos);
//	 WebElement  floor= driver.findElement(By.xpath("//select[@name='floor[]']"));
//	wib.select("4th", floor);
//	WebElement  type= driver.findElement(By.xpath("//select[@name='own[]']"));
//	wib.select("Rented", type);
//	WebElement  vo= driver.findElement(By.xpath("//select[@name='vacant[]']"));
//	wib.select("Vacant", vo);
//	
	
	
	
	
//	
	//Filling all DropDown menu details on Apartment Registration Page
	
	
//	driver.findElement(By.xpath("//button[@name='register_apartment']")).click();
	

	
	//driver.findElement(By.xpath("//a[.='Details/Update']")).click();
	//du.Details(driver);
//	du.Edit(driver);
//	HashMap<String , String> mapts = eib.readMultipleData("Sheet6");
//	du.Editdetails(driver, mapts);
//	du.Submit_Btn(driver);
//	
//	for (Entry<String, String> sets : maps.entrySet()) {
//		if (sets.getKey().equals("purpose")) {
//			WebElement purpos = driver.findElement(By.xpath("//select[@id='" + sets.getKey() + "']"));
//			Select s = new Select(purpos);
//			s.selectByVisibleText(sets.getValue());
//		} else if (sets.getKey().equals("floor[]")) {
//			WebElement floor = driver.findElement(By.xpath("//select[@name='" + sets.getKey() + "']"));
//			Select sp = new Select(floor);			sp.deselectByVisibleText(sets.getValue());
//		} else if (sets.getKey().equals("own[]")) {
//			WebElement type = driver.findElement(By.xpath("//select[@name='" + sets.getKey() + "']"));
//		Select spt = new Select(type);
//		spt.selectByVisibleText(sets.getValue());
//	} else {
//			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='" + sets.getKey() + "']")))).sendKeys(sets.getValue());
//		}

	


	
