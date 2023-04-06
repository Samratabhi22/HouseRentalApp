package Register_Package;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApartmentRoomRegistration {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().create();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Random ran = new Random();
		int num = ran.nextInt();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[.='Login']")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.linkText("Apartment Registration")).click();
		
		
		driver.findElement(By.id("apartment_name")).sendKeys("suresh");
		driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='mobile']")).sendKeys("9874563210");
		driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='email']")).sendKeys("suresh426@gmail.com");
        driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='plot_number']")).sendKeys("226");
        driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='country']")).sendKeys("Guyana");
        driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='state']")).sendKeys("UpperDemerara-Berbice");
        
        driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='city']")).sendKeys("Linden");
        driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='address']")).sendKeys("housing colony");
        driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='image']")).sendKeys("C:\\Users\\Admin\\Desktop\\project tyss\\vasudhaiva-kutumbkum.jpg");
        
        driver.findElement(By.partialLinkText("Add More")).click();
        driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='fullname']")).sendKeys("Suresh Kumar26");
        
        
  driver.findElement(By.id("ap_number_of_plats")).sendKeys("3026");    
  driver.findElement(By.name("rooms[]")).sendKeys("2BHK"); 
  driver.findElement(By.id("area")).sendKeys("Andheri Nagar");
 WebElement purpose = driver.findElement(By.id("purpose"));
 
  Select s= new Select(purpose);
  s.selectByValue("Commercial");
  
  WebElement  floor= driver.findElement(By.id("floor"));
  Select sp= new Select(floor);
  sp.selectByIndex(3);
  WebElement  type= driver.findElement(By.id("ownership"));
  Select spt= new Select(type);
  spt.selectByVisibleText("Rented");
  driver.findElement(By.name("rent[]")).sendKeys("20000"); 
  driver.findElement(By.name("deposit[]")).sendKeys("40000"); 
  driver.findElement(By.name("accommodation[]")).sendKeys("wifi enabled");
  driver.findElement(By.name("description[]")).sendKeys("well furnished room");
  
  
  WebElement  vo= driver.findElement(By.name("vacant[]"));
  Select sptm= new Select(vo);
  sptm.selectByVisibleText("Vacant");
  
  driver.findElement(By.name("register_apartment")).click();
  String str ="Registration successfull. Thank you'";
  String text = driver.findElement(By.xpath("//div[contains(text(),'Registration successfull. Thank you')]/following-sibling::h2[text()='Apartment Room']")).getText();
  if(str.contains(text))
  {
	  System.out.println("Apartment registration sucessfull");
  }
  else
  {
	  System.out.println("Apartment registration not sucessfull");
  }
  
  System.out.println("Done Apartment registeration");
  //Details/Update module 
  
  driver.findElement(By.xpath("//a[.='Details/Update']")).click();
  driver.findElement(By.xpath("//p[text()='suresh426@gmail.com']/ancestor::div[contains(@class,'card')]//a")).click();
  driver.findElement(By.id("description")).sendKeys(" and parking facility");
  Thread.sleep(5000);
  driver.findElement(By.xpath("//button[text()='Submit']")).click();
  
  driver.findElement(By.xpath("//a[.='Details/Update']")).click();
 
  //clicking on complaint button on Details/Update module
  
  driver.findElement(By.xpath("(//p[text()='suresh426@gmail.com']/ancestor::div[@class='card card-inverse card-info mb-3']/following-sibling::a[@class='btn btn-warning float-right'])[1]")).click();
  //raising complaint 
  driver.findElement(By.xpath("//input[@id='name']")).sendKeys("226");
  driver.findElement(By.xpath("//input[@id='cmp']")).sendKeys("Leakage from washroom tap");
  driver.findElement(By.xpath("//button[@name='register']")).click();
  
  
  String data = driver.findElement(By.xpath("//div[text()='Sent Successfully']")).getText();
  String sentSucess="Sent Successfully";
  if(sentSucess.contains(data))
  {
	  System.out.println("Complaint raised sucessfully");
  }
  else
  {
	  System.out.println("Complaint raised not sucessfully");
  }
   //transferring complaint data details to Complaint list module
   driver.findElement(By.xpath("//a[text()='Complaint List']")).click();
   String complainVerify = driver.findElement(By.xpath("//td[text()='226']")).getText();
   String cmplnData="226";
   if(complainVerify.contains(cmplnData))
   {
 	  System.out.println("Complaint data is following in Complaint list module ");
   }
   else
   {
 	  System.out.println("Complaint data is not following in Complaint list module");
   }
		  
   
  
  
  System.out.println("reached end");
  
  driver.close();
  
  
  
  
  
        
		
		
		
		
		
		

	}

}
