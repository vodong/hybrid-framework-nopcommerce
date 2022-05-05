package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public void clickToLoginLin() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);	
	}

	public String getWelcomeText() {
		waitForElementVisible(driver, HomePageUI.WELCOME_TEXT);
		return getElementText(driver, HomePageUI.WELCOME_TEXT);
	}

}
