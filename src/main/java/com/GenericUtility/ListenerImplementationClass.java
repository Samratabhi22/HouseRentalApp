package com.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener{
	ExtentReports report;
	ExtentTest test; 

	public void onTestStart(ITestResult result) {
		//execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"---->Testexecution started");
		
	}

	public void onTestSuccess(ITestResult result) {
	String MethodName=	result.getMethod().getMethodName();
	test.log(Status.PASS,MethodName+"----> Passed");
	Reporter.log(MethodName+"---->Testscript execution sucessful");
		
	}

	public void onTestFailure(ITestResult result) {
//		
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		 File src = edriver.getScreenshotAs(OutputType.FILE);
		String destFilePath ="./screenshot/"+result.getMethod().getMethodName()+LocalDateTime.now().toString().replace(':', '-')+".png";
		 File dest = new File(destFilePath);
		 try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String path = dest.getAbsolutePath(); 
		 test.addScreenCaptureFromPath(path);
		 test.log(Status.FAIL, result.getThrowable());
		 
		// test.addScreenCaptureFromPath(destFilePath, result.getMethod().getMethodName());
		
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		 test.log(Status.SKIP, result.getThrowable());
		 Reporter.log("Testscript execution skipped");
	}

	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report4.html");
		htmlreport.config().setDocumentTitle("HRA");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("House Rental App");
		
		report= new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base_Browser", "chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base_Url", "http://rmgtestingserver/domain/House_Rental_Application/auth/login.php");
		report.setSystemInfo("ReporterName", "Abhishek");
		
	
	}

	public void onFinish(ITestContext context) {
		//consolidate the report
		report.flush();
		
	}

}
