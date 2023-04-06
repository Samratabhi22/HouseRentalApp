package com.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Details_UpdatePage {
	
@FindBy(linkText="Details/Update")
private WebElement Details_Link;
@FindBy (xpath="//p[text()='suresh426@gmail.com']/ancestor::div[@class='card card-inverse card-info mb-3']/following-sibling::a[@class='btn btn-warning float-right'])[1]")
private WebElement Edit_Btn;
@FindBy(id="description")
private WebElement Description_TextField;
@FindBy(xpath="//button[text()='Submit']")
private WebElement Submit_Btn;

public Details_UpdatePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getDetails_Link() {
	return Details_Link;
}

public WebElement getEdit_Btn() {
	return Edit_Btn;
}

public WebElement getSubmit_Btn() {
	return Submit_Btn;
}

public WebElement getDescription_TextField() {
	return Description_TextField;
}
public void Details(WebDriver driver)
{
	Details_Link.click();
}
public void Edit(WebDriver driver)
{
	Edit_Btn.click();
}
public void Description (String value) {
	Description_TextField.sendKeys(value);
}
public void Submit_Btn(WebDriver driver) {
	Submit_Btn.click();
}

public void Editdetails(WebDriver driver,HashMap<String,String> map)
{
for (Entry<String, String>  set: map.entrySet()) {
	
	driver.findElement(By.id("+set.getKey()+")).sendKeys(set.getValue());
	

}

}
}