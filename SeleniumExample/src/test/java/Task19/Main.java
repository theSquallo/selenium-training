package Task19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		MainPage mainPage = new MainPage(driver);
		ProductPage productPage = new ProductPage(driver);
		CartPage cartPage = new CartPage(driver);
		
		mainPage.open();
		int count = mainPage.getCount();
		for(int i=0; i<3; i++) {
			productPage.open(mainPage.links.get(i));
			count++;
			productPage.addToCart(count);
			productPage.back();
		}
		cartPage.open();
		cartPage.removeAllProducts();
		
		driver.quit();
	}

}
