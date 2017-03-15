import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Task14NewWindows {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("http://localhost/litecart/admin");
		
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");	
		
		WebElement login = driver.findElement(By.name("login"));
		login.click();
		
		driver.findElement(By.xpath("//ul[@id='box-apps-menu']//a[contains(@href,'countries')]")).click();
		driver.findElement(By.xpath("//a[@class='button']")).click();
		
		List<WebElement> links = driver.findElements(By.xpath("//form[@method='post']//a[@target='_blank']"));
		String mainTab = driver.getWindowHandle();
		for (int i=0; i<links.size(); i++) {
			links.get(i).click();
			for (String newTab : driver.getWindowHandles()) {
				if (newTab.compareTo(mainTab) != 0) {
					driver.switchTo().window(newTab);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
					driver.close();
				}
			}
			driver.switchTo().window(mainTab);
		}
		
		driver.quit();
		driver = null;
	}
}
