import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class Task9CheckSort {
	public static void main(String[] args) {
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://localhost/litecart/admin");
		
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		
		WebElement login = driver.findElement(By.name("login"));
		login.click();
		
		WebElement section = driver.findElement(By.xpath("//ul[@id='box-apps-menu']//a[contains(@href,'countries')]"));
		section.click();
		
		List<WebElement> countryNames = driver.findElements(By.xpath("//tr[@class='row']//td[5]"));
		List<WebElement> zonesCount = driver.findElements(By.xpath("//tr[@class='row']//td[6]"));
		
		if (isSorted(countryNames)) {
			System.out.println("The names of the countries at the Countries section are sorted in alphabetical order!");
		} else {
			System.out.println("The names of the countries at the Countries section are not sorted in alphabetical order!");
		}
		
		List<String> links = new ArrayList<String>();
		for (int i=0; i<zonesCount.size(); i++) {
			if (Integer.parseInt(zonesCount.get(i).getText()) > 0) {
				links.add(zonesCount.get(i).findElement(By.xpath("../td[5]/a")).getAttribute("href"));
			}
		}
		
		for (int i=0; i<links.size(); i++) {
			driver.findElement(By.xpath("//a[@href='"+links.get(i)+"']")).click();
			List<WebElement> zoneNames = driver.findElements(By.xpath("//table[@id='table-zones']//td[3][position()<last()]"));
			if (isSorted(zoneNames)) {
				System.out.println("The names of the country zones at the Countries section are sorted in alphabetical order!");
			} else {
				System.out.println("The names of the country zones at the Countries section are not sorted in alphabetical order!");
			}
			driver.navigate().back();
		}
		
		links.clear();
		driver.findElement(By.xpath("//ul[@id='box-apps-menu']//a[contains(@href,'geo_zones')]")).click();
		List<WebElement> geozonesCount = driver.findElements(By.xpath("//tr[@class='row']//td[3]/a"));
		for (int i=0; i<geozonesCount.size(); i++) {
			links.add(geozonesCount.get(i).getAttribute("href"));
		}
		
		for (int i=0; i<links.size(); i++) {
			driver.findElement(By.xpath("//a[@href='"+links.get(i)+"']")).click();
			List<WebElement> zoneNames = driver.findElements(By.xpath("//table[@id='table-zones']//td[3]/select"));
			if (isSorted(zoneNames)) {
				System.out.println("The names of the country zones at Geo Zones section are sorted in alphabetical order!");
			} else {
				System.out.println("The names of the country zones at Geo Zones section are not sorted in alphabetical order!");
			}
			driver.navigate().back();
		}
		
		driver.quit();
		driver = null;
	}
	
	private static boolean isSorted(List<WebElement> elements) {
		for (int i=0; i<elements.size()-1; i++) {
			if (elements.get(i).getText().compareTo(elements.get(i+1).getText()) > 0) {
				return false;
			}
		}
		return true;
	}
}
