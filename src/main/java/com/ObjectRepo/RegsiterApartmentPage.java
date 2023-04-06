package com.ObjectRepo;



import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.JavaUtility;

public class RegsiterApartmentPage
{
	
	//declaration
	
	@FindBy(xpath="//a[text()='Apartment Registration']")
	private WebElement apartmentRegTab;
	
	@FindBy(name="apartment_name")
	private WebElement apartmentname;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='mobile']")
	private WebElement mobile;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='plot_number']")
	private WebElement plotNumber;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='country']")
	private WebElement country;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='state']")
	private WebElement state;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='city']")
	private WebElement city;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='landmark']")
	private WebElement landmark;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='address']")
	private WebElement address;
	
	@FindBy(xpath="//a[text()='Add More(Plat Number/Description)']")
	private WebElement description;
	
	@FindBy(xpath="//a[text()='Add More(Plat Number/Description)']")
	private WebElement AddMore;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='fullname[]']")
	private WebElement fullname;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='ap_number_of_plats[]']")
	private WebElement plats;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='rooms[]']")
	private WebElement rooms;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='area[]']")
	private WebElement area;
	
	@FindBy(xpath="//select[@name='purpose[]']")
	private WebElement purpose;
	
	@FindBy(name="floor[]")
	private WebElement floor;
	
	@FindBy(name="own[]")
	private WebElement ownOrrented;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='rent[]']")
	private WebElement rent;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='deposit[]']")
	private WebElement deposit;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='accommodation[]']")
	private WebElement facilities;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/../descendant::input[@name='description[]']")
	private WebElement desc;
	
	@FindBy(name="vacant[]")
	private WebElement vacant;
	
	@FindBy(name="register_apartment")
	private WebElement registerapartment;
	
	

	
	public RegsiterApartmentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	//HashMap<String, String> map = eLib.readMultipleData("Sheet2");
	public String registerapartment(WebDriver driver, HashMap<String, String> map, JavaUtility jLib) {
String nam=null;
	for(Entry<String, String> set: map.entrySet())
	{
		
		String key = set.getKey();
		if(key.equalsIgnoreCase("apartment_name"))
		{
			nam =set.getValue()+jLib.randomTwo();
			driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='"+set.getKey()+"']")).sendKeys(nam);
		}
		
		else 
		{
			driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='"+set.getKey()+"']")).sendKeys(set.getValue());
			
		}
	}
        return nam;

	}
	

	
	//HashMap<String, String> mapA = eLib.readMultipleData("Sheet3");
	public void moreDetails(WebDriver driver, HashMap<String, String> mapA) throws Throwable
	{
		
	for(Entry<String, String> set1: mapA.entrySet())
	{
		driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@id='"+set1.getKey()+"']")).sendKeys(set1.getValue());
	}
	
	}
	
	
	
	public void clickAddMore()
	{
		AddMore.click();
	}
	
	
	
	public void submitRegApartment()
	{
		registerapartment.click();
	}
	
	
	
	

	
	public void clickApartmentRegTab()
	{
		apartmentRegTab.click();
	}
	
	public void checkApartmentReg(WebDriver driver)
	{
	boolean display = driver.findElement(By.xpath("//div[.='Registration successfull. Thank you']")).isDisplayed();
	if(display)
	{
		System.out.println("registration successful");
	}
	else {
		System.out.println("registration not successful");
	}
	}

	public void updateDet(WebDriver driver) throws Throwable
	{
		driver.findElement(By.xpath("//p[text()='Ammant apartment']/../../../child::div[@class='col-5']//b[text()='Apartment Name: ']/../../../../../a")).click();
		driver.findElement(By.name("city")).clear();
		String newDet = "belagavi";
	driver.findElement(By.name("city")).sendKeys(newDet);
	driver.findElement(By.xpath("//button[text()='Submit']")).click();
	DashBoardPagePage d =new DashBoardPagePage(driver);
			d.clickDetailsAndUpdate();
	String text = driver.findElement(By.xpath("//p[text()='Ammant apartment']/../../../child::div[@class='col-5']//b[text()='Apartment Name: ']/../../../../..//b[text()=' City: ']/..")).getText();
	Thread.sleep(3000);
	 if(text.equalsIgnoreCase(newDet))
	 {
		System.out.println("updated successfully");
	 }
	 else
	 {
		 System.out.println("not updated successfully");
	 }
	}	
	
}

