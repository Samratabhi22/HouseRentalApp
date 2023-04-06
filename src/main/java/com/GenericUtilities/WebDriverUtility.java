package com.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * This method is used to maximize the window
	 * @param driver
	 * @author Abhishek 
	 */
public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}
/**
 * This method is used to wait for the page load
 * @param driver
 * @author Abhishek 
 */
public void waitForPageLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
/**
 * This method is used to wait until element to be visible
 * @param driver
 * @param element
 * @author Abhishek 
 */
public void elementTobeVisible(WebDriver driver , WebElement element)

{
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * This method will select the data from dropdown using value
 * @param element
 * @param value
 * @author Abhishek 
 */
public void select (WebElement element , String value)
{
	Select sel = new Select(element);
			sel.selectByValue(value);   
}
/**
 * This method will select the data from dropdown using index
 * @param element
 * @param index
 * @author Abhishek 
 */
public void select(WebElement element , int index)
{
	Select sel = new Select(element);
	sel.selectByIndex(index);
}
/**
 * This method will select the data from dropdown using visible text
 * @param visibleText
 * @param element
 * @author Abhishek 
 */
public void select (String visibleText,WebElement element)
{
	Select sel = new Select (element);
	sel.selectByVisibleText(visibleText);
}
/**
 * This method will perform MouseHover action 
 * @param driver
 * @param element
 * @author Abhishek 
 */
public void mousehover(WebDriver driver , WebElement element)

{
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
}
/**
 * This method will perform drag and drop action 
 * @param driver
 * @param src
 * @param dst
 * @author Abhishek 
 */
public void dragAnddrop(WebDriver driver ,WebElement src, WebElement dst)
{
	Actions act = new Actions(driver);
	act.dragAndDrop(src, dst);
}
/**
 * This method will double click on webpage
 * @param driver
 * @author Abhishek 
 */
public void doubleClickAction(WebDriver driver)
{
	Actions act = new Actions(driver);
	act.contextClick().perform();
}
/**
 * This method will perform right click on Webpage
 * @param driver
 * @author Abhishek 
 */
public void rightClick(WebDriver driver)
{
	Actions act = new Actions(driver);
	act.contextClick().perform();
}
/**
 * This method will perform right click on element
 * @param driver
 * @param element
 * @author Abhishek 
 */
public void rightClick(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * This method will press enter the key
 * @param driver
 * @author Abhishek 
 */
public void enterKeyPress(WebDriver driver )
{
	Actions act = new Actions(driver);
	act.sendKeys(Keys.ENTER).perform();
}
/**
 * This method will press the key 
 * @param driver
 * @throws Throwable
 * @author Abhishek 
 */

public void enterKey(WebDriver driver) throws Throwable
{
	Robot rb = new Robot();
	rb.keyPress(KeyEvent.VK_ENTER);
}
/**
 * This method is used to release the key  
 * @param driver
 * @throws Throwable
 * @author Abhishek 
 */
public void enterRelease(WebDriver driver) throws Throwable
{
	Robot rb = new Robot();
	rb.keyRelease(KeyEvent.VK_ENTER);
}
/**
 * This method will switch the free frame based on index
 * @param driver
 * @param index
 * @author Abhishek 
 */
public void switchToFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
/**
 * This window is used to switch the frame based on address
 * @param driver
 * @param address
 * @author Abhishek 
 */
public void switchToFrame(WebDriver driver,WebElement address)
{
	driver.switchTo().frame(address);
}
/**
 * This window is used to accept alert popup 
 * @param driver
 * @author Abhishek 
 */
public void acceptAlert(WebDriver driver )
{
	driver.switchTo().alert().accept();
}
/**
 * This window is used to cancel alert popup 
 * @param driver
 * @author Abhishek 
 */
public void cancelAlert(WebDriver driver )
{
	driver.switchTo().alert().dismiss();
	
}
/**
 * This method is  used to getWindowHandles to capture all window id's and iterate through the windows
 * and check whether there is next window and capture current window id and switch to current window and capture title 
 * and check whether current window  is expected
 * @param driver
 * @param partialTitle
 * @author Abhishek 
 */
public void switchToWindow(WebDriver driver ,String partialTitle)
{
	//step1: use getWindowHandles to capture all window id's
	Set<String> windows = driver.getWindowHandles();
	//step2: iterate through the windows
	Iterator<String> it = windows.iterator();
//step3: check whether there is next window 
	while(it.hasNext())
	{ 
		//Step 4 : capture current window id
		String winId = it.next();
		
		//step 5 : switch to current window and capture title 
		String currentWinTitle = driver.switchTo().window(winId).getTitle();
		//step 6: check whether current window  is expected 
		if(currentWinTitle.contains(partialTitle))
		{
			break;
		}
	}
	
}
/**
 * This method will take screenshot and store it in folder called as screenshot
 * @param driver
 * @param screenShotName
 * @return
 * @throws Throwable
 * @author Abhishek 
 */
	public String getScreenShot(WebDriver driver,String screenShotName) throws Throwable 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path= ".\\screenshot\\"+screenShotName+".png";
		File dest = new File (path);
		FileUtils.copyFile(src, dest);
		return path;
	}
	/**
	 * This method will perform  random scroll 
	 * @param driver
	 * @author Abhishek 
	 */
	
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)", "");
	}
	/**
	 * This method will scroll until specified element is found
	 * @param driver
	 * @param element
	 * @author Abhishek 
	 */
	public void scrollAction(WebDriver driver,WebElement element )
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
		//jse.executeScript("argument[0].scrollIntoView()",element);
	}
	

}



