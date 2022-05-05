package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static HomePageObject getHomepage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginpage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterpage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static DashBoardPageObject getDashboarPage(WebDriver driver) {
		return new DashBoardPageObject(driver);
	}

}
