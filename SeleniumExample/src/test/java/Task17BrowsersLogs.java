import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;

public class Task17BrowsersLogs {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://localhost/litecart/admin");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.xpath("//ul[@id='box-apps-menu']//a[contains(@href,'catalog')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'category_id=1')]")).click();
		
		List<WebElement> links = driver.findElements(By.xpath("//a[contains(@href, 'product_id') and @title='Edit']"));
		int prodCount = links.size();
		int count = 0;
		
		while (count < prodCount) {
			links = driver.findElements(By.xpath("//a[contains(@href, 'product_id') and @title='Edit']"));
			links.get(count).click();
			//((JavascriptExecutor) driver).executeScript("console.error('Some error');");
			List<LogEntry> logs = driver.manage().logs().get("browser").getAll();
			if (logs.size() > 0) {
				for (int i=0; i<logs.size(); i++) {
					System.out.println(logs.get(i).getTimestamp() + logs.get(i).getMessage());
				}
			} else {
				System.out.println("No logs in the browser!");
			}
			driver.navigate().back();
			count++;
		}
				
		driver.quit();
		driver = null;
	}

}
	