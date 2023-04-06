package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class HomePage {
//Declaration
	@FindBy(linkText="Registered Users: ")
	private WebElement RegisteredUsersLink;
	@FindBy(linkText="Rooms for Rent: ")
	private WebElement RoomsForRentLink;
	@FindBy(linkText="Home")
	private WebElement HomeLink;
	@FindBy(linkText="Register")
	private WebElement RegisterLink;
	@FindBy(linkText="Details/Update")
	private WebElement Details_UpdateLink;
	@FindBy(linkText="Send SMS")
	private WebElement SendSMSLink;
	@FindBy(linkText="Complaint List")
	private WebElement ComplaintListLink;
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement LogoutBtn;
	@FindBy(xpath="//a[text()='Logo/Home']")
	private WebElement LogoLink;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//getter methods of above found elements
	public WebElement getRegisteredUsersLink() {
		return RegisteredUsersLink;
	}
	public WebElement getRoomsForRentLink() {
		return RoomsForRentLink;
	}
	public WebElement getHomeLink() {
		return HomeLink;
	}
	public WebElement getRegisterLink() {
		return RegisterLink;
	}
	public WebElement getDetails_UpdateLink() {
		return Details_UpdateLink;
	}
	public WebElement getSendSMSLink() {
		return SendSMSLink;
	}
	public WebElement getComplaintListLink() {
		return ComplaintListLink;
	}
	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}
	public WebElement getLogoLink() {
		return LogoLink;
	}
	
	//Utilization
	public void registeredUsersLink(WebDriver driver) {
		RegisteredUsersLink.click();
	}
	public void roomsForRentLink(WebDriver driver) {
		RoomsForRentLink.click();
	}
	public void homeLink(WebDriver driver) {
		HomeLink.click();
	}
	public void registerLink(WebDriver driver) {
		RegisterLink.click();
	}
	public void details_UpdateLink(WebDriver driver) {
		Details_UpdateLink.click();
	}
	public void sendSMSLink(WebDriver driver) {
		SendSMSLink.click();
	}
	public void complaintListLink(WebDriver driver) {
		ComplaintListLink.click();
	}
	public void logoutBtn(WebDriver driver) {
		LogoutBtn.click();
	}
	public void logoLink(WebDriver driver) {
		LogoLink.click();
	}
	
	
	
	
	
}