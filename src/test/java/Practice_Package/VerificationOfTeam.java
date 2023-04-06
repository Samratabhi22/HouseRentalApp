package Practice_Package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerificationOfTeam {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		//String teamName="Singapore"; //present 
		String teamName="Singapor";  //not present
		List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		List<WebElement> matches = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		boolean flag=false;
		for (WebElement name: teams) {
			String text= name.getText();
			if(text.equals(teamName))
			{
				System.out.println("is present");
				flag=true;
				break;
				
			}
			
		}
		if(!flag)
		{
			System.out.println("not present");
		}
	

	}

}
