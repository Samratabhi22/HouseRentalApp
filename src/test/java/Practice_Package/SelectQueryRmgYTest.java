package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectQueryRmgYTest {

	public static void main(String[] args) throws Throwable {
		
		
	}
//		Connection con = null;
//		String expProj="TY_PROJ_2200";
//		  ResultSet result = null;
//		 try {
//			 WebDriverManager.chromedriver().setup();
//			 WebDriver driver = new ChromeDriver();
//			 driver.manage().window().maximize();
//			 driver.get("http://rmgtestingserver:8084/");
//			 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//			 driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
//			 driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
//			driver.findElement(By.xpath("//button[text()='Sign in']")).click();
//			
//			Thread.sleep(5000);
//			driver.findElement(By.xpath("//a[text()='Projects']")).click();
//			driver.findElement(By.xpath("//span[text()='Create Project']")).click();
//			
//			 driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("JAI RAJPUTANA 108");
//			 driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("RAJPUTS");
//			 WebElement dropdown = driver.findElement(By.xpath("//select[@name='status']"));
//			 Select s = new Select(dropdown);
//			 s.selectByVisibleText("On Gogin");
//			 driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
//			 
//			 
//			 Driver driver1 = new Driver();
//			 DriverManager.registerDriver(driver1);
//			 DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
//			 Statement stat = con.createStatement();
//			 String query = "select* from project;";
//			  result = stat.executeQuery(query);
//			 boolean flag = false;
//			 while(result.next())
//			 {
//				String actProj = result.getString(4);
//				System.out.println(actProj);
//				if(actProj.equalsIgnoreCase(expProj))
//				{
//					flag=true;
//					break;
//				}
//			 }
//			 if(flag)
//			 {
//				 System.out.println("Project is created");
//			 }
//			 else
//			 {
//				 System.out.println("Project is not created");
//			 }
//			 
//	 }
//		 catch(Exception e)
//		 {
//			 
//		 }
//		 finally
//		 {
//			 con.close();
//		 }
//		 
//
//	}

}
