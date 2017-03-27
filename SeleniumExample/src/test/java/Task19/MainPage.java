package Task19;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page{

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void open(){
		driver.get("http://localhost/litecart");
	}
	
	@FindBy(xpath="//a[@class='link' and contains(@title,'Duck')]")
	protected List<WebElement> links;
	
	public int getCount(){
		WebElement count = driver.findElement(By.xpath("//span[@class='quantity']"));
		return Integer.valueOf(count.getText());
	}
}
