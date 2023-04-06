package com.ObjectRepo;



import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.ExcelUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

public class RegisterInduvidualHomePage
{

	@FindBy(name="fullname")
	private WebElement fullname;
	
	@FindBy(name="mobile")
	private WebElement mobile;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="plot_number")
	private WebElement PlotNumber;
	
	@FindBy(name="rooms")
	private WebElement rooms;
	
	@FindBy(name="country")
	private WebElement country;
	
	@FindBy(name="state")
	private WebElement state;
	
	@FindBy(name="city")
	private WebElement city;
	
	@FindBy(name="rent")
	private WebElement rent;
	
	@FindBy(name="sale")
	private WebElement sale;
	
	@FindBy(name="deposit")
	private WebElement deposit;
	
	@FindBy(name="accommodation")
	private WebElement facilities;
	
	@FindBy(name="description")
	private WebElement description;
	
	@FindBy(name="landmark")
	private WebElement landmark;
	
	@FindBy(name="address")
	private WebElement address;
	
	@FindBy(name="vacant")
	private WebElement vacant;
	
	@FindBy(name="image")
	private WebElement image;
	
	@FindBy(name="register_individuals")
	private WebElement submit;
	
	@FindBy(xpath="//h2[text()='Register Room']")
	private WebElement InduvidualHomeHeader;
	
	@FindBy(xpath ="//a[text()='Logout']")
	private WebElement logout;
	
	@FindBy(xpath="//div[.='Registration successfull. Thank you']")
	private WebElement RegMessage;
	
	public RegisterInduvidualHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void registerHome(WebDriver driver,JavaUtility jLib,HashMap<String, String> map) {
	for(Entry<String, String> set :map.entrySet())
	{
		String key = set.getKey();
		
		if(key.equalsIgnoreCase("fullname"))
		{
			driver.findElement(By.id(set.getKey())).sendKeys(set.getValue()+jLib.random());
		}
		else if(key.equalsIgnoreCase("email"))
		{
			driver.findElement(By.id(set.getKey())).sendKeys("T"+jLib.random()+set.getValue());
		}
		else if(key.equalsIgnoreCase("mobile"))
		{
			driver.findElement(By.id(set.getKey())).sendKeys(set.getValue()+jLib.randomTwo());
			System.out.println(set.getValue());
		}
		else {
			driver.findElement(By.id(set.getKey())).sendKeys(set.getValue());
		}
	}
	}
	

	public void selectVacant(WebDriverUtility wLib)
	{
		wLib.select("Occupied", vacant);
	}
	
	public void registerInduvidualHome()
	{
		submit.click();
	}
	
	public String InduvidualHomeHeader()
	{
		String Text = InduvidualHomeHeader.getText();
		return Text;
	}
	
	public void logout()
	{
		logout.click();
	}
	
	public void checkReg(WebDriver driver) {
	boolean display =RegMessage.isDisplayed();
	if(display)
	{
		System.out.println("registration successful");
	}
	else 
	{
		System.out.println("registration not successful");
	}
	}
	
	public void clearCity()
	{
		city.clear();
	}
	
	public void editCity(String newCity) throws Throwable
	{
		city.sendKeys(newCity);
	}
	
	public void verifyEditDetails(WebDriver driver) throws Throwable
	{
		ExcelUtility eLib = new ExcelUtility();
		String name2 = eLib.readDataFromExcel("Sheet6", 1, 0);
		String newCity = eLib.readDataFromExcel("Sheet6", 0, 0);
		 boolean Expected = driver.findElement(By.xpath("//p[text()='"+name2+"']/..//b[text()=' City: ']/parent::p[text()='"+newCity+"']")).isDisplayed();
		 if(Expected)
		 {
		 	System.out.println("edited sucessfully");
		 	
		 }
		 else
		 {
		 System.out.println("edit not successful");	
		 }
		 }
		
	
	
}

