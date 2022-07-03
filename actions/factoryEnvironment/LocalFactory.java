package factoryEnvironment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalFactory {
	private WebDriver driver;
	private String browserName;
	
	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}
	
	public WebDriver createDriver() {
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		if(browser == Browser.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		}else if(browser == Browser.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser == Browser.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
		}else {
			throw new RuntimeException("Browser name is invalid");
		}
		
		return driver;
	}
}
