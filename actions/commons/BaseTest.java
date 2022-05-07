package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
//	private String projectPath = System.getProperty("user.dir");
	
	protected WebDriver getBrowserDriver(String browserName) {
		if(browserName.equals("firefox")) {
//			  System.setProperty("webdriver.gecko.driver", projectPath + "\\browserdrivers\\geckodriver.exe");
			  WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver(); 
		  }else if(browserName.equals("chrome")) {
//			  System.setProperty("webdriver.chrome.driver", projectPath + "\\browserdrivers\\chromedriver.exe");
			  WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
		  }else if(browserName.equals("edge")) {
//			  System.setProperty("webdriver.edge.driver", projectPath + "\\browserdrivers\\msedgedriver.exe");
			  WebDriverManager.edgedriver().setup();
			  driver = new ChromeDriver();
		  }else {
			  throw new RuntimeException("Browser name is invalid");
		  }
//		driver.get("http://live.techpanda.org/index.php/");
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
}
