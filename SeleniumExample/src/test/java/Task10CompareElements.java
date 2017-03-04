import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;

public class Task10CompareElements {	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new InternetExplorerDriver();
		//WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost/litecart");
		
		List<WebElement> products = driver.findElements(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']"));
		WebElement prodName = products.get(0).findElement(By.xpath(".//div[@class='name']"));
		WebElement regPrice = products.get(0).findElement(By.xpath(".//s[@class='regular-price']"));
		WebElement disPrice = products.get(0).findElement(By.xpath(".//strong[@class='campaign-price']"));
		
		String mainPg_name = prodName.getText();
		String mainPg_regPrice = regPrice.getText();
		String mainPg_disPrice = disPrice.getText();
		
		String color = regPrice.getCssValue("color");
		if (regPrice.getTagName().equals("s") && 
				(color.equals("rgba(119, 119, 119, 1)") || color.equals("rgb(119, 119, 119)"))) {
			System.out.println("Regular price text is strikethrough and color is grey (#777) on main page!");
		}
		
		color = disPrice.getCssValue("color");
		if (disPrice.getTagName().equals("strong") && 
				(color.equals("rgba(204, 0, 0, 1)") || color.equals("rgb(204, 0, 0)"))) {
			System.out.println("Campaign price text is bold and color is red (#c00) on main page!");
		}
		
		if (disPrice.getCssValue("font-size").compareTo(regPrice.getCssValue("font-size")) > 0) {
			System.out.println("Campaign price font-size is bigger than regular price font-size on main page!");
		}

		products.get(0).findElement(By.xpath(".//a[@class='link']")).click();
		prodName = driver.findElement(By.xpath("//h1[@class='title']"));
		regPrice = driver.findElement(By.xpath("//div[@class='price-wrapper']/s"));
		disPrice = driver.findElement(By.xpath("//div[@class='price-wrapper']/strong"));
		
		String prodPg_name = prodName.getText();
		String prodPg_regPrice = regPrice.getText();
		String prodPg_disPrice = disPrice.getText();
		
		color = regPrice.getCssValue("color");
		if (regPrice.getTagName().equals("s") && 
				(color.equals("rgba(102, 102, 102, 1)") || color.equals("rgb(102, 102, 102)"))) {
			System.out.println("Regular price text is strikethrough and color is grey (#666) on product's details page!");
		}
		
		color = disPrice.getCssValue("color");
		if (disPrice.getTagName().equals("strong") && 
				(color.equals("rgba(204, 0, 0, 1)") || color.equals("rgb(204, 0, 0)"))) {
			System.out.println("Campaign price text is bold and color is red (#c00) on product's details page!");
		}
		
		if (disPrice.getCssValue("font-size").compareTo(regPrice.getCssValue("font-size")) > 0) {
			System.out.println("Campaign price font-size is bigger than regular price font-size on product's details page!");
		}
		
		if (mainPg_name.equals(prodPg_name) && mainPg_regPrice.equals(prodPg_regPrice) && mainPg_disPrice.equals(prodPg_disPrice)) {
			System.out.println("Product name, regular price and discount price are same on both main and product's details pages!");
		}
		
		driver.quit();
		driver = null;
	}
}