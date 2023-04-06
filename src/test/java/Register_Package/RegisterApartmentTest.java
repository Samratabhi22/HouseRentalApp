package Register_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtilities.FileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterApartmentTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib = new FileUtility();
		// fetch common data
//		FileInputStream fis = new FileInputStream("./src/test/resources/Commondata.properties");
//		Properties p = new Properties();
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");

		FileInputStream fish = new FileInputStream("./src/test/resources/Readexcel.xlsx");
		Workbook wb = WorkbookFactory.create(fish);
		Sheet sh = wb.getSheet("Sheet2");
		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Random ran = new Random();
		int num = ran.nextInt();

		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[.='Login']")).click();
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// register module
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.linkText("Apartment Registration")).click();
		HashMap<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 0; i <= sh.getLastRowNum(); i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		for (Entry<String, String> set : map.entrySet()) {
			// driver.findElement(By.id(set.getKey())).sendKeys(set.getValue());

			driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());

			// driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());

		}

//		driver.findElement(By.xpath("//input[@id='apartment_name']")).sendKeys("suresh");
//				
//		driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='mobile']")).sendKeys("9874563210");
//		driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='email']")).sendKeys("suresh426@gmail.com");
//        driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='plot_number']")).sendKeys("226");
//        driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='country']")).sendKeys("Guyana");
//        driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='state']")).sendKeys("UpperDemerara-Berbice");
//        
//        driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='city']")).sendKeys("Linden");
//        driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='address']")).sendKeys("housing colony");
//        driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='image']")).sendKeys("C:\\Users\\Admin\\Desktop\\project tyss\\vasudhaiva-kutumbkum.jpg");

		driver.findElement(By.cssSelector(".btn.btn-info.btn-sm")).click();
		
		HashMap<String, String> maps = new LinkedHashMap<String, String>();
		for (int i = 0; i <= sh.getLastRowNum(); i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			maps.put(key, value);
		}
		for (Entry<String, String> sets : maps.entrySet()) {
			driver.findElement(By.xpath(sets.getKey())).sendKeys(sets.getValue());
		}
		// driver.findElement(By.xpath("//h2[text()='Apartment
		// Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='fullname']")).sendKeys("Suresh
		// Kumar26");

//  driver.findElement(By.xpath("//input[@id='ap_number_of_plats']")).sendKeys("3026");    
//  driver.findElement(By.xpath("//input[@name='rooms[]']")).sendKeys("2BHK"); 
//  driver.findElement(By.xpath("//input[@name='area[]']")).sendKeys("Andheri Nagar");
		for (Entry<String, String> set : map.entrySet()) {
			if (set.getKey().equals("purpose")) {
				WebElement purpos = driver.findElement(By.xpath("//select[@id='" + set.getKey() + "']"));
				Select s = new Select(purpos);
				s.selectByVisibleText(set.getValue());
			} else if (set.getKey().equals("floor[]")) {
				WebElement floor = driver.findElement(By.xpath("//select[@name='" + set.getKey() + "']"));
				Select sp = new Select(floor);
				sp.deselectByVisibleText(set.getValue());
			} else if (set.getKey().equals("own[]")) {
				WebElement type = driver.findElement(By.xpath("//select[@name='" + set.getKey() + "']"));
				Select spt = new Select(type);
				spt.selectByVisibleText(set.getValue());
			} else {
				wait.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("//input[@name='" + set.getKey() + "']"))))
						.sendKeys(set.getValue());
			}
		}
// WebElement purpose = driver.findElement(By.xpath("//select[@id='purpose']"));
// 
// Select s= new Select(purpose);
// s.selectByVisibleText("Commercial");
// 
// WebElement  floor= driver.findElement(By.xpath("//select[@name='floor[]']"));
// Select sp= new Select(floor);
// sp.deselectByVisibleText("4th");
// WebElement  type= driver.findElement(By.xpath("//select[@name='own[]']"));
// Select spt= new Select(type);
// spt.selectByVisibleText("Rented");
// driver.findElement(By.xpath("//input[@name='rent[]']")).sendKeys("20000"); 
// driver.findElement(By.xpath("//input[@name='deposit[]']")).sendKeys("40000"); 
// driver.findElement(By.xpath("//input[@name='accommodation[]']")).sendKeys("wifi enabled");
// driver.findElement(By.xpath("//input[@name='description[]']")).sendKeys("well furnished room");
		for (Entry<String, String> set : map.entrySet()) {
			if (set.getKey().equals("vacant[]")) {
				WebElement vo = driver.findElement(By.xpath("//select[@name='" + set.getKey() + "']"));
				Select sptm = new Select(vo);
				sptm.selectByVisibleText(set.getValue());
			} else {
				wait.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("//button[@name='" + set.getKey() + "']")))).sendKeys(set.getValue());
			}

		}

// WebElement  vo= driver.findElement(By.xpath("//select[@name='vacant[]']"));
// Select sptm= new Select(vo);
// sptm.selectByVisibleText("Vacant");

		driver.findElement(By.xpath("//button[@name='register_apartment']")).click();
		String str = "Registration successfull. Thank you'";
		String text = driver.findElement(By.xpath(
				"//div[contains(text(),'Registration successfull. Thank you')]/following-sibling::h2[text()='Apartment Room']"))
				.getText();
		if (str.contains(text)) {
			System.out.println("Apartment registration sucessfull");
		} else {
			System.out.println("Apartment registration not sucessfull");
		}

		System.out.println("Done Apartment registeration");
		// Details/Update module

		driver.findElement(By.xpath("//a[.='Details/Update']")).click();
		driver.findElement(By.xpath("//p[text()='suresh426@gmail.com']/ancestor::div[contains(@class,'card')]//a"))
				.click();
		// driver.findElement(By.xpath("//input[@name='description']")).sendKeys(" and
		// parking facility");
// Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		driver.findElement(By.xpath("//a[.='Details/Update']")).click();

		// clicking on complaint button on Details/Update module

		driver.findElement(By.xpath(
				"(//p[text()='suresh426@gmail.com']/ancestor::div[@class='card card-inverse card-info mb-3']/following-sibling::a[@class='btn btn-warning float-right'])[1]"))
				.click();
		// raising complaint
// driver.findElement(By.xpath("//input[@id='name']")).sendKeys("226");
		// driver.findElement(By.xpath("//input[@id='cmp']")).sendKeys("Leakage from
		// washroom tap");
		driver.findElement(By.xpath("//button[@name='register']")).click();
		String data = driver.findElement(By.xpath("//div[text()='Sent Successfully']")).getText();

		// Complaint registered successfully

		String sentSucess = "Sent Successfully";
		if (sentSucess.contains(data)) {
			System.out.println("Complaint raised sucessfully");
		} else {
			System.out.println("Complaint raised not sucessfully");
		}
		// transferring complaint data details to Complaint list module

		driver.findElement(By.xpath("//a[text()='Complaint List']")).click();
		String complainVerify = driver.findElement(By.xpath("//td[text()='226']")).getText();
		String cmplnData = "226";
		if (complainVerify.contains(cmplnData)) {
			System.out.println("Complaint data is following in Complaint list module ");
		}

		else {
			System.out.println("Complaint data is not following in Complaint list module");
		}

		System.out.println("reached end");

		driver.close();

	}

}
