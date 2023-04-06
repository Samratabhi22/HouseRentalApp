package com.RegisterPackage;


import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register_InduvidualHomeAndMessage{

	public static void main(String[] args) throws Throwable
	{
		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://rmgtestingserver/domain/House_Rental_Application/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Random r = new Random();
		int num = r.nextInt(100000);
			
		driver.findElement(By.xpath("//a[.='Login']")).click();
		
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.xpath("//a[.='Register']")).click();
		
		driver.findElement(By.id("fullname")).sendKeys("WarisSuresh"+num);
		driver.findElement(By.id("mobile")).sendKeys("78754"+num);
		driver.findElement(By.id("alternat_mobile")).sendKeys("98482"+num); 
		driver.findElement(By.id("email")).sendKeys("tapo+"+num+"+@gmail.com");
		driver.findElement(By.id("plot_number")).sendKeys("45AB");
		driver.findElement(By.id("rooms")).sendKeys("2BHK");
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.id("state")).sendKeys("Karnataka");
		driver.findElement(By.id("city")).sendKeys("Bangalore");
		driver.findElement(By.id("rent")).sendKeys("8000");
		driver.findElement(By.id("sale")).sendKeys("45000");
		driver.findElement(By.id("deposit")).sendKeys("15000");
		driver.findElement(By.id("accommodation")).sendKeys("All amenities");
		driver.findElement(By.id("description")).sendKeys("Brand new ");
		driver.findElement(By.id("landmark")).sendKeys("BTM");
		driver.findElement(By.id("address")).sendKeys("4th cross road, btm");
		driver.findElement(By.xpath("//option[@value='1']")).click();
		
		driver.findElement(By.id("image")).sendKeys("C:\\Users\\panth\\Downloads\\download.jpg");
		

	driver.findElement(By.name("register_individuals")).click();
	
	Thread.sleep(5000);
	boolean display = driver.findElement(By.xpath("//div[.='Registration successfull. Thank you']")).isDisplayed();
	if(display)
	{
		System.out.println("registration successful");
	}
	else {
		System.out.println("registration not successful");
	}
	
	driver.findElement(By.xpath("//a[.='Send SMS']")).click();
	
	driver.findElement(By.xpath("//input[@value='1234567890']")).click();
	driver.findElement(By.xpath("//input[@name='message']")).sendKeys("Rent not paid");
	driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();	
	
	
	//String data = driver.findElement(By.xpath("//p[text()='sureshWaris43917']/../p[7]")).getText();
	
	//System.out.println(data);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
