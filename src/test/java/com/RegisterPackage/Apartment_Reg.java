

package com.RegisterPackage;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.GenericUtility.DatabaseUtility;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;
import com.ObjectRepo.DashBoardPagePage;
import com.ObjectRepo.RegsiterApartmentPage;
import com.ObjectRepo.RegsiterApartmentPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Apartment_Reg extends BaseClass {

		@Test
		public void  regApt() throws Throwable
		{

			RegsiterApartmentPage ap =new RegsiterApartmentPage(driver);
			DashBoardPagePage d =new DashBoardPagePage(driver);
			d.clickRegister();
			ap.clickApartmentRegTab();
			
			HashMap<String, String> map = eLib.readMultipleData("Sheet2");

	String	na =ap.registerapartment(driver, map, jLib);
			ap.clickAddMore();
			System.out.println(na);
			HashMap<String, String> mapA = eLib.readMultipleData("Sheet3");
			Assert.fail();
			ap.moreDetails(driver, mapA);
			ap.submitRegApartment();
		ap.checkApartmentReg(driver);
	}

}

