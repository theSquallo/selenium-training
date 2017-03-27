package Task19;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends Page{

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	public void open(WebElement link) {
		driver.get(link.getAttribute("href"));
	}
	
	public void addToCart(int count) {
		if (elementExists(driver, By.xpath("//td[@class='options']"))) {
			Select select = new Select(driver.findElement(By.xpath("//select[@name='options[Size]']")));
			select.selectByVisibleText("Small");
		}
		driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
		if (wait.until(ExpectedConditions.textToBe(By.xpath("//span[@class='quantity']"), String.valueOf(count)))) {
			System.out.println("Product successfully added to cart!");
		};
	}
	
	public void back() {
		driver.navigate().back();
	}
	
	private boolean elementExists(WebDriver driver, By locator) {
	    try {
	        driver.findElement(locator);
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	}
}
