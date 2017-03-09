//import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Task11NewUser {	
	public static void main(String[] args) {
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://localhost/litecart");
		
		String email = getEmail("host.com", 6);
		String password = "1q2w#E$R";
		
		// Creation of New User
		driver.findElement(By.xpath("//a[contains(@href,'create_account')]")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("FirstName");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("LastName");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Some Address");
		driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("New York");
		Select country = new Select(driver.findElement(By.xpath("//select[@name='country_code']")));
		country.selectByVisibleText("United States");
		Select state;
		try {
			state = new Select(driver.findElement(By.xpath("//select[@name='zone_code']")));
			state.selectByVisibleText("New York");
		} catch (NoSuchElementException ex) {
			System.out.println("No such element!");
		}
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("+19876543210");
		driver.findElement(By.xpath("//input[@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='confirmed_password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@name='create_account']")).click();
		
		// Logout and Login
		driver.findElement(By.xpath("//a[contains(@href, 'logout')]")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		driver.findElement(By.xpath("//a[contains(@href, 'logout')]")).click();		
				
		driver.quit();
		driver = null;
	}
	
	private static String getEmail(String domain, int length) {
		return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz") + "@" + domain;
	}
}