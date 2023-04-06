package Practice_Package;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlymicsXpathMedalsTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
//		String countryName="Armenia";
//		List<WebElement> country = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
//		List<WebElement> gold = driver.findElements(By.xpath("//div[@title='Gold']/span[@data-cy='medal-main']"));
//		List<WebElement> silver = driver.findElements(By.xpath("//div[@title='Silver']/span[@data-cy='medal-main']"));
//		List<WebElement> bronze = driver.findElements(By.xpath("//div[@title='Bronze']/span[@data-cy='medal-main']"));
//		for(int i=0;i<country.size();i++)
//		{
//			if(country.contains(countryName)) {
//			System.out.println(country.get(i).getText()+" "+gold.get(i).getText()+" "+silver.get(i).getText()+" "+bronze.get(i).getText());
//			break;
//		}
		
		
//			List<WebElement> country = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
//		ArrayList<String> list = new ArrayList<String>();
//		for (int i=0;i<country.size();i++)
//		{
//			
//		list.add(country.get(i).getText());
//		
//	
//		}
//		for (String specificCountry : list) {
//			
//			
//		}
		String ag="Armenia";
		String gold = driver.findElement(By.xpath("//span[.='"+ag+"']/parent::div/following-sibling::div[@title='Gold']/span")).getText();
		String silver= driver.findElement(By.xpath("//span[.='"+ag+"']/parent::div/following-sibling::div[@title='Silver']/span")).getText();
		
		String bronze = driver.findElement(By.xpath("//span[.='"+ag+"']/parent::div/following-sibling::div[@title='Bronze']/span")).getText();
		String total = driver.findElement(By.xpath("//span[.='"+ag+"']/parent::div/following-sibling::div[contains(@data-medal-id,'total-medals-row')]/span")).getText();
		System.out.println(ag+"  "+"Gold = "+gold+"  "+"Silver = "+silver+"  "+"Bronze = "+bronze+" Total = "+total);
		
	}
}
