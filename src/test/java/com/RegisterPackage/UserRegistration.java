package com.RegisterPackage;


import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;

import com.ObjectRepo.UserRegistrationPage;
import com.ObjectRepo.WelcomePage;

public class UserRegistration extends BaseClass{

	@Test
	public void UserRegistrations() throws Throwable
	{
	 WelcomePage wl=new WelcomePage(driver);
	 wl.logo();
	 wl.RegisterUser();

	HashMap<String, String> map = eLib.readMultipleData("UserReg");
		Thread.sleep(2000);
	 UserRegistrationPage user=new UserRegistrationPage(driver);
		user.UserRegistrations(driver, map, jLib); 
		user.SubmitUsers();
boolean expt=driver.findElement(By.xpath("//div[text()='Registration successfull. Now you can login']")).isDisplayed();
if(expt)
{
	 System.out.println("registar sucessfully");
}
else
{
	 System.out.println("not registar ");

}
System.out.println("done");
wl.logo();
wl.home();

	
		
	
	
	
	
}
}
