package Practice_Package;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_Grid {
	@Test
	public  void test(String[] args) throws MalformedURLException, InterruptedException {
	
		String executeMode="local";
		WebDriver driver =null;
		if(executeMode.equals("remote"))
		{
			URL url = new URL("http://192.168.43.88:4444/wd");
			
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			driver= new RemoteWebDriver(url, cap);
			
		}
		else if(executeMode.equals("local"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("https://google.com");
		Thread.sleep(1000);
		driver.quit();
	}

}
