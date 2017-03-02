import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Task7AdminSections {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		driver.get("http://localhost/litecart/admin");
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("admin");
		WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
		login.click();
		
		int secCnt = 0;
		int i = 0;
		secCnt = driver.findElements(By.xpath("//ul[@id='box-apps-menu']//a")).size();
		do {
			List<WebElement> sections = driver.findElements(By.xpath("//ul[@id='box-apps-menu']/li/a[1]"));
			sections.get(i).click();
			if (isElementPresent(driver, By.xpath("//h1"))) {
				System.out.println("Header is present: " + driver.findElement(By.xpath("//h1")).getText());
			} else {
				System.out.println("Header is abcent!");
			}
			
			int subSecCnt = 0;
			int j = 1;
			subSecCnt = driver.findElements(By.xpath("//ul[@id='box-apps-menu']//ul[@class='docs']//a")).size();
			
			while (j < subSecCnt) {
				List<WebElement> subSections = driver.findElements(By.xpath("//ul[@id='box-apps-menu']//ul[@class='docs']//a"));
				subSections.get(j).click();
				if (isElementPresent(driver, By.xpath("//h1")) == true) {
					System.out.println("Header is present: " + driver.findElement(By.xpath("//h1")).getText());
				} else {
					System.out.println("Header is abcent!");
				}
				j++;
			};
			i++;
		} while (i < secCnt);
		driver.quit();
		driver = null;
	}
	
	static boolean isElementPresent(WebDriver driver, By locator) {
		  try {
		    driver.findElement(locator);
		    return true;
		  } catch (NoSuchElementException ex) {
		    return false;
		  }
	}
}
