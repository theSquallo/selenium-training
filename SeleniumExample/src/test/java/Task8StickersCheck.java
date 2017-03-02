import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Task8StickersCheck {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://localhost/litecart");
		
		int stickerCnt = 0;
		List<WebElement> products = driver.findElements(By.xpath("//li[@class='product column shadow hover-light']"));
		for (int i=0;i<products.size();i++) {
			try {
				List<WebElement> sticker = products.get(i).findElements(By.xpath(".//div[contains(@class, 'sticker')]"));	
				if (sticker.size() == 1) {
					System.out.println("There is 1 sticker " + sticker.get(0).getText() + " on " + 
							products.get(i).findElement(By.xpath(".//div[@class='name']")).getText() + "!");
					stickerCnt ++;
				} else {
					System.out.println("Element has less or more than 1 sticker!");
				}
			} catch(NoSuchElementException ex) {
				System.out.println("No sticker on this element!");
			}
		}
		if (stickerCnt >= products.size()) {
			System.out.println("All products have stickers!");
		} else {
			System.out.println("Not all products have stickers!");
		}
		
		driver.quit();
		driver = null;
	}
}
