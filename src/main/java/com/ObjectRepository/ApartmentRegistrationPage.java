package com.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class ApartmentRegistrationPage
{
	@FindBy(linkText="Apartment Registration")
	private WebElement Apartment_Registration_tab;
	
	@FindBy(name="apartment_name")
	private WebElement ApartmentNameTextField;
	@FindBy(xpath="//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='mobile']")
	private WebElement Apartment_Mobile_TextField;
	
	@FindBy(xpath="//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='email']")
	private WebElement Apartment_Email_TextField;
	@FindBy(xpath="//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='plot_number']")
	private WebElement Apartment_plot_number_TextField;
	@FindBy(xpath="//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='country']")
	private WebElement Apartment_country_TextField;
	@FindBy(xpath="//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='state']")
	private WebElement Apartment_state_TextField;
	@FindBy(xpath="//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='city']")
	private WebElement Apartment_city_TextField;
	@FindBy(xpath="//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='landmark']")
	private WebElement Apartment_landmark_TextField;
	@FindBy(xpath="//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='address']")
	private WebElement Apartment_address_TextField;
	@FindBy(xpath="//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='image']")
	private WebElement ChooseFile_Apartment_Image;
	@FindBy(linkText="Add More(Plat Number/Description)")
	private WebElement AddMoreBtn;
	
	@FindBy(name="purpose[]")
	private WebElement PurposeDD;
	@FindBy(name ="floor[]")
	private WebElement FloorDD;
	@FindBy(name ="own[]")
	private WebElement OwnerDD ;
	@FindBy(name ="vacant[]")
	private WebElement VacantDD;
	
	
	
	@FindBy(name="fullname[]")
	private WebElement Apartment_FullName_TextField;
	@FindBy(name="ap_number_of_plats[]")
	private WebElement Apartment_FlatNumber_TextField;
	@FindBy(name="rooms[]")
	private WebElement Apartment_Rooms_TextField;
	@FindBy(name="area[]")
	private WebElement Apartment_Area_TextField;
	@FindBy(name="rent[]")
	private WebElement Apartment_Rent_TextField;
	@FindBy(name="deposit[]")
	private WebElement Apartment_Deposit_TextField;
	@FindBy(name="accommodation[]")
	private WebElement Apartment_accommodation_TextField;
	@FindBy(name="description[]")
	private WebElement Apartment_Description_TextField;
	@FindBy(xpath ="//button[@value='register_apartment']")
	private WebElement Submit_Btn;
	
	
	
	public ApartmentRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//public ApartmentRegistrationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	//}

	public WebElement getApartment_Registration_tab() {
		return Apartment_Registration_tab;
	}
	public WebElement getApartmentNameTextField() {
		return ApartmentNameTextField;
	}
	public WebElement getApartment_Mobile_TextField() {
		return Apartment_Mobile_TextField;
	}
	public WebElement getApartment_Email_TextField() {
		return Apartment_Email_TextField;
	}
	public WebElement getApartment_plot_number_TextField() {
		return Apartment_plot_number_TextField;
	}
	public WebElement getApartment_country_TextField() {
		return Apartment_country_TextField;
	}
	public WebElement getApartment_state_TextField() {
		return Apartment_state_TextField;
	}
	public WebElement getApartment_city_TextField() {
		return Apartment_city_TextField;
	}
	public WebElement getApartment_landmark_TextField() {
		return Apartment_landmark_TextField;
	}
	public WebElement getApartment_address_TextField() {
		return Apartment_address_TextField;
	}
	public WebElement getChooseFile_Apartment_Image() {
		return ChooseFile_Apartment_Image;
	}
	public WebElement getAddMoreBtn() {
		return AddMoreBtn;
	}
	public WebElement getPurposeDD() {
		return PurposeDD;
	}
	public WebElement getFloorDD() {
		return FloorDD;
	}
	public WebElement getOwnerDD() {
		return OwnerDD;
	}
	public WebElement getVacantDD() {
		return VacantDD;
	}
	public WebElement getApartment_FullName_TextField() {
		return Apartment_FullName_TextField;
	}
	public WebElement getApartment_FlatNumber_TextField() {
		return Apartment_FlatNumber_TextField;
	}
	public WebElement getApartment_Rooms_TextField() {
		return Apartment_Rooms_TextField;
	}
	public WebElement getApartment_Area_TextField() {
		return Apartment_Area_TextField;
	}
	public WebElement getApartment_Rent_TextField() {
		return Apartment_Rent_TextField;
	}
	public WebElement getApartment_Deposit_TextField() {
		return Apartment_Deposit_TextField;
	}
	public WebElement getApartment_accommodation_TextField() {
		return Apartment_accommodation_TextField;
	}
	public WebElement getApartment_Description_TextField() {
		return Apartment_Description_TextField;
	}
	public WebElement getSubmit_Btn() {
		return Submit_Btn;
	}
	
	
	
	public void Apartment_Registration_tab(WebDriver driver) {
		Apartment_Registration_tab.click();
	}
	public void ApartmentNameTextField(String ApartmentName) {
		ApartmentNameTextField.sendKeys(ApartmentName);
	}
	public void Apartment_Mobile_TextField(String mobile) {
		Apartment_Mobile_TextField.sendKeys(mobile);
	}
	public void Apartment_Email_TextField(String email) {
		Apartment_Email_TextField.sendKeys(email);
	}
	public void Apartment_plot_number_TextField(String plot) {
		Apartment_plot_number_TextField.sendKeys(plot);
	}
	public void Apartment_country_TextField(String country) {
		Apartment_country_TextField.sendKeys(country);
	}
	public void Apartment_state_TextField(String state) {
		Apartment_state_TextField.sendKeys(state);
	}
	public void Apartment_city_TextField(String city) {
		Apartment_city_TextField.sendKeys(city);
	}
	public void Apartment_landmark_TextField(String landmark) {
		Apartment_landmark_TextField.sendKeys(landmark);
	}
	public void Apartment_address_TextField(String address) {
		Apartment_address_TextField.sendKeys(address);
	}
	public void ChooseFile_Apartment_Image(String imagePath) {
	ChooseFile_Apartment_Image.sendKeys(imagePath);
	}
	public void AddMoreBtn(WebDriver driver) {
		AddMoreBtn.click();
	}
	public void PurposeDD(WebDriverUtility wib) {
		wib.select("Commercial",PurposeDD);
	}
	public void FloorDD(WebDriverUtility wib) {
		 wib.select("4th",FloorDD);
	}
	public void OwnerDD(WebDriverUtility wib) {
		wib.select("Rented",OwnerDD);
	}
	public void VacantDD(WebDriverUtility wib) {
		wib.select("Vacant",VacantDD);
	}
	public void Apartment_FullName_TextField(String fullname) {
		Apartment_FullName_TextField.sendKeys(fullname);
	}
	public void Apartment_FlatNumber_TextField(String flat) {
		Apartment_FlatNumber_TextField.sendKeys(flat);
	}
	public void Apartment_Rooms_TextField(String rooms) {
	Apartment_Rooms_TextField.sendKeys(rooms);
	}
	public void Apartment_Area_TextField(String area) {
		Apartment_Area_TextField.sendKeys(area);
	}
	public void Apartment_Rent_TextField(String rent) {
		Apartment_Rent_TextField.sendKeys(rent);
	}
	public void Apartment_Deposit_TextField(String deposit) {
		Apartment_Deposit_TextField.sendKeys(deposit);
	}
	public void Apartment_accommodation_TextField(String accomodation) {
		Apartment_accommodation_TextField.sendKeys(accomodation);
	}
	public void Apartment_Description_TextField(String description) {
		Apartment_Description_TextField.sendKeys(description);
	}
	public void Submit_Btn(WebDriver driver) {
		Submit_Btn.click();
	}
	

	public void apartmentdetails(WebDriver driver,HashMap<String,String> map)
	{
for (Entry<String, String>  set: map.entrySet()) {
		
		driver.findElement(By.xpath("//h2[text()='Apartment Room']/ancestor::div[@role='alert']//descendant::div[@class='form-group']/input[@id='"+set.getKey()+"']")).sendKeys(set.getValue());

	}
	}
	public void apartmentMoreDetails(HashMap<String,String> maps,WebDriver driver) {
      for (Entry<String, String> sets : maps.entrySet()) {
	
	driver.findElement(By.xpath("//h2[text()='Apartment Room']/../descendant::input[@name='"+sets.getKey()+"']")).sendKeys(sets.getValue());

}
	}
	public void allDropDown(HashMap<String, String >mapss , WebDriver driver,WebDriverUtility wib) {
for (Entry<String, String> setss : mapss.entrySet()) 
	
{
	if (setss.getKey().equals("purpose")) 
	{
	WebElement purpos = driver.findElement(By.xpath("//select[@id='" + setss.getKey() + "']"));
	wib.select("Commercial", purpos);
	}	
	else if (setss.getKey().equals("floor[]")) 
	{		WebElement floor = driver.findElement(By.xpath("//select[@name='" + setss.getKey() + "']"));
	wib.select("4th", floor);		
	//sp.selectByVisibleText(sets.getValue());
	} else if (setss.getKey().equals("own[]")) {
		WebElement type = driver.findElement(By.xpath("//select[@name='" + setss.getKey() + "']"));
		wib.select("Rented", type);
	
}
	
	else {
		
	WebElement vacantt =driver.findElement(By.xpath("//select[@name='" + setss.getKey() + "']"));
	vacantt.sendKeys((setss.getValue()));
	wib.elementTobeVisible(driver, vacantt);
	}
	}


}
	public void registrationApartment_sucessful(WebDriver driver) {
		String str = "Registration successfull. Thank you'";
		String text = driver.findElement(By.xpath("//div[contains(text(),'Registration successfull. Thank you')]/following-sibling::h2[text()='Apartment Room']")).getText();
		if (str.contains(text)) {
			System.out.println("Apartment registration sucessfull");
		} else {
			System.out.println("Apartment registration not sucessfull");
		}

		System.out.println("Done Apartment registeration");
		
	}
	public void addMore(WebDriver driver)
	{
		driver.findElement(By.cssSelector(".btn.btn-info.btn-sm")).click();
	}
	
}