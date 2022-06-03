package commons;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	protected final Log log;
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
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
		driver.get(GlobalConstants.PORTAL_DEV_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME_OUT, TimeUnit.SECONDS);
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
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
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME_OUT, TimeUnit.SECONDS);
		return driver;
	}
	
//	protected WebDriver getBrowserDriver(String browserName, String environmentName) {
//		if(browserName.equals("firefox")) {
////			  System.setProperty("webdriver.gecko.driver", projectPath + "\\browserdrivers\\geckodriver.exe");
//			  WebDriverManager.firefoxdriver().setup();
//			  driver = new FirefoxDriver(); 
//		  }else if(browserName.equals("chrome")) {
////			  System.setProperty("webdriver.chrome.driver", projectPath + "\\browserdrivers\\chromedriver.exe");
//			  WebDriverManager.chromedriver().setup();
//			  driver = new ChromeDriver();
//		  }else if(browserName.equals("edge")) {
////			  System.setProperty("webdriver.edge.driver", projectPath + "\\browserdrivers\\msedgedriver.exe");
//			  WebDriverManager.edgedriver().setup();
//			  driver = new ChromeDriver();
//		  }else {
//			  throw new RuntimeException("Browser name is invalid");
//		  }
////		driver.get("http://live.techpanda.org/index.php/");
//		driver.get(getEnvironmentUrl(environmentName));
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME, TimeUnit.SECONDS);
//		return driver;
//	}
	
	protected String getEnvironmentUrl(String environmentName) {
		String url = null;
		switch (environmentName) {
		case "DEV":
			url = GlobalConstants.PORTAL_DEV_URL;
			break;
		case "TEST":
			url = GlobalConstants.PORTAL_TESTING_URL;
			break;
		}
		return url;
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			System.out.println(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	protected void closeBrowserAndDriver() {
		String cmd = "";
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			if (driverInstanceName.contains("chrome")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driverInstanceName.contains("internetexplorer")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driverInstanceName.contains("firefox")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				} else {
					cmd = "pkill geckodriver";
				}
			} else if (driverInstanceName.contains("edge")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				} else {
					cmd = "pkill msedgedriver";
				}
			} else if (driverInstanceName.contains("opera")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
				} else {
					cmd = "pkill operadriver";
				}
			} else if (driverInstanceName.contains("safari")) {
				if (osName.contains("mac")) {
					cmd = "pkill safaridriver";
				}
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public WebDriver getDriverInstance() {
		return this.driver;
	}
}
