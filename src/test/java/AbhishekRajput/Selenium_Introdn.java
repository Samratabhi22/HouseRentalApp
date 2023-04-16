package AbhishekRajput;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_Introdn {

	public static void main(String[] args) {
		//Invoking Browser

		//Chrome - ChromeDriver exten->Methods close get

		//Firefox- FirefoxDriver ->methods close get

		// WebDriver  close  get

		//WebDriver methods + class methods

		// Chrome

		         ChromeOptions options = new ChromeOptions();

		         options.addArguments("--remote-allow-origins=*");
		         //system.setProperty is a java method
		         
		         //selenium searches for this key internally--->webdriver.chrome.driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		//Firefox
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Desktop\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		//edge
		
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\Desktop\\msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.quit();

	}

}
