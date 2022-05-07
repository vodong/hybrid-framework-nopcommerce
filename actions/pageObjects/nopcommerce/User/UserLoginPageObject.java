package pageObjects.nopcommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopcommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
		
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIl_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIl_ERROR_MESSAGE);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementClickable(driver, UserLoginPageUI.PASSWORD_TEXBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXBOX, password);
	}

	public String getErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.ERROR_MESSAGE);
	}

	public void inputToEmailTextBox(String email) {
		waitForElementClickable(driver, UserLoginPageUI.EMAIL_TEXBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXBOX, email);
	}

	public UserHomePageObject loginAsUser(String email, String password) {
		inputToEmailTextBox(email);
		inputToPasswordTextBox(password);
		clickToLoginButton();
		return PageGeneratorManager.getHomePage(driver);
	}
}
