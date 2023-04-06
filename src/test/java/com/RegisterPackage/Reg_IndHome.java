package com.RegisterPackage;



import java.util.HashMap;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.JavaUtility;
import com.ObjectRepo.DashBoardPagePage;
import com.ObjectRepo.RegisterInduvidualHomePage;


@Listeners(com.GenericUtility.ListenerImplementationClass.class)
public class Reg_IndHome extends BaseClass
{
	
	@Test(retryAnalyzer = com.GenericUtility.RetryImpClass.class)
	public void regIndHome() throws Throwable
	{
	DashBoardPagePage d =new DashBoardPagePage(driver);
	d.clickRegister();
	
	JavaUtility jLib = new JavaUtility();
	HashMap<String, String> map = eLib.readMultipleData("Sheet1");
	RegisterInduvidualHomePage reg =new RegisterInduvidualHomePage(driver);
	Assert.fail();
	reg.registerHome(driver, jLib, map);
	
	
	reg.registerInduvidualHome();
	eLib.closeWorkbook(ExcelUtility.workBook());
	//reg.checkReg(driver);
	}
}

