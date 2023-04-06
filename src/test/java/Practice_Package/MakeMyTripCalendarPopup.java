package Practice_Package;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripCalendarPopup {

	public static void main(String[] args) {
		//notification popups
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
		driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
		//selecting round trip
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		//selecting from
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("Bengaluru, India");
		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("Delhi");
		driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
		//fetching system date and pass to test script as a current travel date
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		Date cdate= new Date();
		System.out.println(cdate);
		String []d=cdate.toString().split(" ");
		
  String day= d[0];
   String month= d[1];
	String date = d[2];
	String year = d[5];
	
	String travelDate=day+" "+month+" "+date+" "+year;
	driver.findElement(By.xpath("//div[@aria-label='"+travelDate+"']")).click();
	// passing return date
	 String rday="Thursday ,";
	 String rmonth = "Jun";
	 String rdate = "15";
	 String ryear = "2023";
	 
	 String returnDate =rday+" "+rmonth+" "+rdate+" "+ryear;
	 System.out.println(returnDate);
	 //giving infinity loop to select the future date
	 for(; ;)
	 {
		 try
		 {
			 driver.findElement(By.xpath("//input[@id='return']")).click();
			 driver.findElement(By.xpath("//div[@aria-label='"+returnDate+"']"));
		 }
		 catch(Exception e)
		 {
			 //clicking on forward arrow button 
			 driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			 
		 }
		 
	 
	 //giving no of travellers
	 
	 driver.findElement(By.xpath("//span[@class='lbl_input appendBottom5']")).click();
	 driver.findElement(By.xpath("//li[@data-cy='adults-4']")).click();
	 driver.findElement(By.xpath("//button[text()='APPLY']")).click();
	 //click on search
	 driver.findElement(By.xpath("//a[text()='Search']")).click();
	 
	}
	}
}
   
