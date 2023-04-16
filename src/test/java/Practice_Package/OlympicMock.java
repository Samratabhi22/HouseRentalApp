package Practice_Package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicMock {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://olympics.com/en/athletes/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	List<WebElement> data = driver.findElements(By.xpath("//span[text()='USA']/ancestor::article//span[@class='athlete--name no-trunc']"));
	for(WebElement value : data)
	{
		System.out.println(value.getText());
	}
	driver.close();

	}

}
