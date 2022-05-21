package pageObject.jQuery;

import org.openqa.selenium.WebDriver;

public class pageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

}
