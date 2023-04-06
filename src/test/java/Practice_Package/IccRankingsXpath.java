package Practice_Package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccRankingsXpath {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> postns = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		List<WebElement> matches = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		List<WebElement> points = driver.findElements(By.xpath("//tbody/tr/td[4]"));
		List<WebElement> ratings = driver.findElements(By.xpath("//tbody/tr/td[5]"));
		for(int i=1; i<postns.size();i++) {
			
			System.out.println(postns.get(i).getText()+"  "+teams.get(i).getText()+" "+matches.get(i).getText()+" "+points.get(i).getText()+" "+ratings.get(i).getText());
		}

	}

}
