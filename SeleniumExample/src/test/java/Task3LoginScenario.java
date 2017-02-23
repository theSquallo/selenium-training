import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

public class Task3LoginScenario {

	public static void main(String[] args) {
		// Путь к вспомогательному файлу
		System.setProperty("webdriver.gecko.driver","C:\\Users\\mrsqu\\Documents\\GitHub\\FirefoxWebDriver\\geckodriver.exe");
    	
		// Инициализация драйвера
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Переход по адресу http://localhost/litecart/admin
		driver.get("http://localhost/litecart/admin");
		
		// Поиск элемента и ввод имени пользователя
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		
		// Поиск элемента и ввод пароля
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		
		// Нажатие на кнопку для входа
		WebElement login = driver.findElement(By.name("login"));
		login.click();		
		
		// Выход из панели администратора
		WebElement logout = driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[2]/a[5]"));
		logout.click();
		
		// Закрытие браузера и драйвера
		driver.quit();
	}

}
