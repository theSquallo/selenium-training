import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Task13AddToCart {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://localhost/litecart/");
		int prodCount = java.lang.Integer.parseInt((driver.findElement(By.xpath("//span[@class='quantity']")).getText()));
		
		driver.findElement(By.xpath("//li[@class='category-1']/a")).click();
		driver.findElement(By.xpath("(//ul[@class='listing-wrapper products']//a[@class='link'])[1]")).click();
		if (elementExists(driver, By.xpath("//td[@class='options']"))) {
			Select sel = new Select(driver.findElement(By.xpath("//select[@name='options[Size]']")));
			sel.selectByVisibleText("Small");
		}
		driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
		prodCount++;
		if (wait.until(ExpectedConditions.textToBe(By.xpath("//span[@class='quantity']"), String.valueOf(prodCount)))) {
			System.out.println("Product successfully added to cart!");
		};
		
		driver.findElement(By.xpath("//li[@class='category-1']/a")).click();
		driver.findElement(By.xpath("(//ul[@class='listing-wrapper products']//a[@class='link'])[2]")).click();
		if (elementExists(driver, By.xpath("//td[@class='options']"))) {
			Select sel = new Select(driver.findElement(By.xpath("//select[@name='options[Size]']")));
			sel.selectByVisibleText("Small");
		}
		driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
		prodCount++;
		if (wait.until(ExpectedConditions.textToBe(By.xpath("//span[@class='quantity']"), String.valueOf(prodCount)))) {
			System.out.println("Product successfully added to cart!");
		};
		
		driver.findElement(By.xpath("//li[@class='category-1']/a")).click();
		driver.findElement(By.xpath("(//ul[@class='listing-wrapper products']//a[@class='link'])[3]")).click();
		if (elementExists(driver, By.xpath("//td[@class='options']"))) {
			Select sel = new Select(driver.findElement(By.xpath("//select[@name='options[Size]']")));
			sel.selectByVisibleText("Small");
		}
		driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
		prodCount++;
		if (wait.until(ExpectedConditions.textToBe(By.xpath("//span[@class='quantity']"), String.valueOf(prodCount)))) {
			System.out.println("Product successfully added to cart!");
		};
		
		driver.findElement(By.xpath("//div[@id='cart']/a[@class='content']")).click();
		while (prodCount > 0) {
			if (prodCount > 1) {
				List<WebElement> orders = driver.findElements(By.xpath("//ul[@class='shortcuts']//a"));
				orders.get(prodCount-1).click();
				List<WebElement> buttons = driver.findElements(By.xpath("//button[@name='remove_cart_item']"));
				wait.until(ExpectedConditions.visibilityOf(buttons.get(prodCount-1))).click();
				wait.until(ExpectedConditions.stalenessOf(buttons.get(prodCount-1)));
				prodCount--;
				wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//td[@class='item']"))));
				List<WebElement> ordersCount = driver.findElements(By.xpath("//td[@class='item']"));
				if (prodCount == ordersCount.size()) {
					System.out.println("Product successfully removed from cart!");
				}
			} else {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@name='remove_cart_item']")))).click();
				wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//button[@name='remove_cart_item']"))));
				prodCount--;
				wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//td[@class='item']"))));
				List<WebElement> ordersCount = driver.findElements(By.xpath("//td[@class='item']"));
				if (prodCount == ordersCount.size()) {
					System.out.println("Product successfully removed from cart!");
				}
			}
		}
				
		driver.quit();
		driver = null;
	}
	
	private static boolean elementExists(WebDriver driver, By locator) {
	    try {
	        driver.findElement(locator);
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	}
}
