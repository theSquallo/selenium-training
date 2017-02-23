import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

public class Task3LoginScenario {

	public static void main(String[] args) {
		// Path for GeckoDriver
		System.setProperty("webdriver.gecko.driver","C:\\Users\\mrsqu\\Documents\\GitHub\\FirefoxWebDriver\\geckodriver.exe");
    	
		// WebDrver Initialization
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Go to http://localhost/litecart/admin
		driver.get("http://localhost/litecart/admin");
		
		// Search for element username
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		
		// Search for element password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		
		// Click login button
		WebElement login = driver.findElement(By.name("login"));
		login.click();		
		
		// Click logout button
		WebElement logout = driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[2]/a[5]"));
		logout.click();
		
		// Close WebDriver
		driver.quit();
	}

}
