package com.ObjectRepo;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsAndUpdate {

	
	//Declearation
	@FindBy(xpath="//p[text()='kingkong']/../../../a")
	private WebElement editPath;
	
	//Inithialization
	public DetailsAndUpdate(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public void Edit(String name,WebDriver driver)
	{
		  editPath.click();

	}
}
