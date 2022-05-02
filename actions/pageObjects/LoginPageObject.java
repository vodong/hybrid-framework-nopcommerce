package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, LoginPageUI.EMAIl_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIl_ERROR_MESSAGE);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXBOX, password);
	}

	public String getErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.ERROR_MESSAGE);
	}

	public void inputToEmailTextBox(String email) {
		waitForElementClickable(driver, LoginPageUI.EMAIL_TEXBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXBOX, email);
	}

}
