package Register_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IndividualHomeRegistrationAndVerify {

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
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.name("fullname")).sendKeys("Raja Rani");
		driver.findElement(By.name("fullname")).sendKeys("Raja Rani");
		

	}

}
