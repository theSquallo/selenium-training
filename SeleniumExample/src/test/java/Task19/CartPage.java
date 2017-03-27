package Task19;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends Page{

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO јвтоматически созданна€ заглушка конструктора
	}
	
	public void open() {
		driver.get("http://localhost/litecart/en/checkout");
	}
	
	public void removeAllProducts() {
		int prodCount = driver.findElements(By.xpath("//ul[@class='shortcuts']//a")).size();
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
				wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//td[@class='item']"))));
				prodCount--;				
				List<WebElement> ordersCount = driver.findElements(By.xpath("//td[@class='item']"));
				if (prodCount == ordersCount.size()) {
					System.out.println("Product successfully removed from cart!");
				}
			}
		}
	}

}
