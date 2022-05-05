package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getLoginpage(driver);
	}


}
