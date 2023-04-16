package Practice_Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT_BUS_PRICE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disabled-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		//  maximize the browser
		driver.manage().window().maximize();
		//url of app
		driver.get("https://www.makemytrip.com/");
		//implicit wait duration
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//close popup
		driver.findElement(By.xpath("//a[@class='close']")).click();
		

	}

}
