package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//Declaration
	@FindBy(linkText="Login")
	private WebElement login_Link;
	@FindBy(name="username")
	private WebElement usernameEdt;
	@FindBy(name ="password")
	private WebElement passwordEdt;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitBtn;
	
	//initialization
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	

	public WebElement getLogin_Link() {
		return login_Link;
	}



	


	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmit() {
		return submitBtn;
	}
	
	//utilization
	public void loginLink(WebDriver driver)
	{
		login_Link.click();
	}
	public void loginPage(String USERNAME,String PASSWORD)
	{
		
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		submitBtn.click();
		
		
	}
}
