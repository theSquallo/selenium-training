import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

public class Task3LoginScenario {

	public static void main(String[] args) {
		// ���� � ���������������� �����
		System.setProperty("webdriver.gecko.driver","C:\\Users\\mrsqu\\Documents\\GitHub\\FirefoxWebDriver\\geckodriver.exe");
    	
		// ������������� ��������
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// ������� �� ������ http://localhost/litecart/admin
		driver.get("http://localhost/litecart/admin");
		
		// ����� �������� � ���� ����� ������������
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		
		// ����� �������� � ���� ������
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		
		// ������� �� ������ ��� �����
		WebElement login = driver.findElement(By.name("login"));
		login.click();		
		
		// ����� �� ������ ��������������
		WebElement logout = driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[2]/a[5]"));
		logout.click();
		
		// �������� �������� � ��������
		driver.quit();
	}

}
