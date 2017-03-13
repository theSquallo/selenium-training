import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import java.io.File;

public class Task12AddProduct {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("http://localhost/litecart/admin");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");	
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.xpath("//ul[@id='box-apps-menu']//a[contains(@href,'catalog')]")).click();
		driver.findElement(By.xpath("//td[@id='content']//a[contains(@href, 'edit_product')]")).click();
		
		driver.findElement(By.xpath("//input[@name='status'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name='name[en]']")).sendKeys("Spider Duck");
		driver.findElement(By.xpath("//input[@name='code']")).sendKeys("rd006");
		driver.findElement(By.xpath("//input[@name='categories[]'][@value='0']")).click();
		driver.findElement(By.xpath("//input[@name='categories[]'][@value='1']")).click();
		Select category;
		try {
			category = new Select(driver.findElement(By.xpath("//select[@name='default_category_id']")));
			category.selectByVisibleText("Rubber Ducks");
		} catch (NoSuchElementException ex) {
			System.out.println("No such element!");
		}
		driver.findElement(By.xpath("//input[@name='quantity']")).clear();
		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("30");
		Select status;
		try {
			status = new Select(driver.findElement(By.xpath("//select[@name='sold_out_status_id']")));
			status.selectByVisibleText("Temporary sold out");
		} catch (NoSuchElementException ex) {
			System.out.println("No such element!");
		}
		
		File classpathRoot = new File(System.getProperty("user.dir"));
		File picture = new File(classpathRoot, "spider_duck.JPG");
		String picturePath = picture.getPath();
		driver.findElement(By.xpath("//input[@name='new_images[]']")).sendKeys(picturePath);
		
		driver.findElement(By.xpath("//input[@name='date_valid_from']")).sendKeys("01.03.2017");
		driver.findElement(By.xpath("//input[@name='date_valid_to']")).sendKeys("01.03.2018");
		
		driver.findElement(By.xpath("//a[@href='#tab-information']")).click();
		Select manufacturer;
		try {
			manufacturer = new Select(driver.findElement(By.xpath("//select[@name='manufacturer_id']")));
			manufacturer.selectByVisibleText("ACME Corp.");
		} catch (NoSuchElementException ex) {
			System.out.println("No such element!");
		}
		driver.findElement(By.xpath("//input[@name='short_description[en]']")).sendKeys("Short description");
		driver.findElement(By.xpath("//div[@class='trumbowyg-editor']")).sendKeys("Description");
		
		driver.findElement(By.xpath("//a[@href='#tab-prices']")).click();
		driver.findElement(By.xpath("//input[@name='purchase_price']")).clear();
		driver.findElement(By.xpath("//input[@name='purchase_price']")).sendKeys("10");
		Select currency;
		try {
			currency = new Select(driver.findElement(By.xpath("//select[@name='purchase_price_currency_code']")));
			currency.selectByVisibleText("US Dollars");
		} catch (NoSuchElementException ex) {
			System.out.println("No such element!");
		}
		
		driver.findElement(By.xpath("//button[@name='save']")).click();
		driver.quit();
		driver = null;
	}
}
