package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
		return PageGeneratorManager.getRegisterpage(driver);
	}
}
