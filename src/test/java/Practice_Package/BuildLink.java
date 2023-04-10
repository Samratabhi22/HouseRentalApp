package Practice_Package;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BuildLink {
@Test
	public static void build() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("https://phptravels.com/");
	List<WebElement> listofAllLink = driver.findElements(By.xpath("//a"));
	List<String> listoflink = new ArrayList<String>();
	List<String> brokensLinks = new ArrayList<String>();
	
	for ( WebElement webElement : listofAllLink) {
		String link = webElement.getAttribute("href");
		if(link!=null)
		{
			if(link.contains("http"))
			{
				listoflink.add(link);
				
			}
			else
			{
				brokensLinks.add(link+" ===> Not Having HTTP protocol ");
			}
		}
			else
			{
				brokensLinks.add(link+" ===> Null ");
			}
			
		
	}
	for (String link : listoflink) {
		try {
			URL url = new URL(link);
			URLConnection urlCOn = url.openConnection();
			HttpURLConnection httpUrlCon=(HttpURLConnection)urlCOn;
		int statusCode = httpUrlCon.getResponseCode();
			String respMsg = httpUrlCon.getResponseMessage();
			if(statusCode>=400)
				
			{
				brokensLinks.add(link+" ===> Status code : "+statusCode+ "===>Response Msg :"+respMsg);
			}
		}
		catch(Exception e)
		{
			brokensLinks.add(link+" ===> Not Connected to server ");
		}
		
	}
	System.out.println(brokensLinks);
	System.out.println(brokensLinks.size());

	}

}
