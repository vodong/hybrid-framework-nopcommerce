package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class BrowserStackFactory {
	private WebDriver driver;
	private String browserName;
	private String osName;
	private String osVersion;
	
	public BrowserStackFactory(String browserName, String osName, String osVersion) {
		this.browserName = browserName;
		this.osName = osName;
		this.osVersion = osVersion;
	}
	
	public WebDriver createDriver() {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("os", osName);
		capability.setCapability("os_version", osVersion);
		capability.setCapability("browser", browserName);
		capability.setCapability("browser_version", "latest");
		capability.setCapability("browserstack.debug", "true");
		capability.setCapability("project", "NopCommerce");
		capability.setCapability("name", "Run on" + osName + " | " + osVersion + " | " + browserName);
		
		if(osName.contains("Windows")) {
			capability.setCapability("resolution", "1920x1080");
		}else {
			capability.setCapability("resolution", "1920x1440");
		}
		
		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSE_STACK_URL), capability);
		}catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return driver;
	}
}
