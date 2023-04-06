package Register_Package;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserRegistrationTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fib = new FileUtility();
		JavaUtility jib = new JavaUtility();
		DatabaseUtility dib = new DatabaseUtility();
		WebDriverUtility wib = new WebDriverUtility();
		ExcelUtility eib= new ExcelUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		wib.maximizeWindow(driver);
		
		
		String Url = fib.readDataFromPropertyFile("url");
		driver.get(Url);
		wib.waitForPageLoad(driver);
	driver.findElement(By.xpath("//a[text()='Register']")).click();
	//wib.waitForPageLoad(driver);
		HashMap <String , String> map = eib.readMultipleData("User_Regn");
		for (Entry<String, String> set : map.entrySet()) {
			String key= set.getKey()+jib.randomNum();
			if(key.equalsIgnoreCase("mobile"))
			{
				driver.findElement(By.xpath("//input[@name='"+set.getKey()+"']")).sendKeys(key);
			}
			else if (key.equalsIgnoreCase("email"))
			{
				driver.findElement(By.xpath("//input[@name='"+set.getKey()+"']")).sendKeys(jib.randomNum()+set.getValue());
			}else {
			
			driver.findElement(By.xpath("//input[@name='"+set.getKey()+"']")).sendKeys(set.getValue());
			}
		}
//		driver.findElement(By.xpath("//input[@name='fullname']")).click();
//		driver.findElement(By.xpath("//input[@name='mobile']")).click();
//		driver.findElement(By.xpath("//input[@name='email']")).click();
//		driver.findElement(By.xpath("//input[@name='password']")).click();
//	driver.findElement(By.xpath("//input[@name='c_password']")).click();
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		//wib.waitForPageLoad(driver);
		System.out.println("User registration is sucssfull");
		//wib.waitForPageLoad(driver);
		driver.findElement(By.xpath("//a[.='Login']")).click();
		//wib.waitForPageLoad(driver);
		HashMap <String , String> maps = eib.readMultipleData("User_Regn_Login");
		for (Entry<String, String> sets : maps.entrySet()) {
			String keys= sets.getKey();
			if (keys.equalsIgnoreCase("username"))
			{
		driver.findElement(By.xpath("//input[@name='"+sets.getKey()+"']")).sendKeys(sets.getValue());
			}
			else {
		driver.findElement(By.xpath("//input[@name='"+sets.getKey()+"']")).sendKeys(sets.getValue());
	}
		

	}
		driver.findElement(By.xpath("//button[@name='login']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		driver.findElement(By.xpath("//b[text()='Registered Users: ']")).click();
	String str = driver.findElement(By.xpath("//td[text()='1xyz@gmail.com']")).getText();
	System.out.println(str);
	if(str.contains("1xyz@gmail.com"))
	{
		System.out.println("user is sucessfully registered");
	}
		
		
		System.out.println("reached end");
		//wib.waitForPageLoad(driver);
		}
	}

