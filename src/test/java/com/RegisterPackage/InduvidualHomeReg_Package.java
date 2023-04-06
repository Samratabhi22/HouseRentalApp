package com.RegisterPackage;



import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class InduvidualHomeReg_Package {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties p =new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String UN=p.getProperty("username");
		String PW=p.getProperty("password");
		
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\RMG.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("sheet1");
		
		
		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*Random r = new Random();
		int num = r.nextInt(100000);
		int namenum= r.nextInt(100);	
		*/
		driver.findElement(By.xpath("//a[.='Login']")).click();
		
		driver.findElement(By.name("username")).sendKeys(UN);
		driver.findElement(By.name("password")).sendKeys(PW);
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.xpath("//a[.='Register']")).click();
		
		HashMap<String, String> map=new HashMap<String, String>();
		for(int i=0; i<=sh.getLastRowNum(); i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		
		for(Entry<String, String> set: map.entrySet())
		{
			Thread.sleep(2000);
			driver.findElement(By.id(set.getKey())).sendKeys(set.getValue());
			
		}
		
		
	/*	
		driver.findElement(By.id("fullname")).sendKeys("WarisSuresh"+num);
		driver.findElement(By.id("mobile")).sendKeys("78754"+num);
		driver.findElement(By.id("alternat_mobile")).sendKeys("98482"+num);
		driver.findElement(By.id("email")).sendKeys("tapo+"+namenum+"+@gmail.com");
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
		
		*/
		driver.findElement(By.xpath("//option[@value='1']")).click();
		
		driver.findElement(By.id("image")).sendKeys("C:\\Users\\panth\\Downloads\\download.jpg");
		

	driver.findElement(By.name("register_individuals")).click();
	
	//driver.findElement(By.xpath("//div[.='Registration successfull. Thank you']")).getText();
	
	
	
	
	
	Thread.sleep(5000);
	boolean display = driver.findElement(By.xpath("//div[.='Registration successfull. Thank you']")).isDisplayed();
	if(display)
	{
		System.out.println("registration successful");
	}
	else {
		System.out.println("registration not successful");
	}
	
	driver.findElement(By.xpath("//a[text()='Logout']")).click(); 

	}

}

