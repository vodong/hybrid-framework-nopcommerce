package pageObjects.nopcommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopcommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);	
	}

	public String getErrorMessageAtFirstNameTextBox() {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextBox() {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextBox() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextBox() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirstNameTextBox(String firstName) {
		waitForElementClickable(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
		
	}

	public void inputToLastNameTextBox(String lastName) {
		waitForElementClickable(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);	
	}

	public void inputToEmailTextBox(String email) {
		waitForElementClickable(driver, UserRegisterPageUI.EMAIL_TEXBOX);
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXBOX, email);	
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementClickable(driver, UserRegisterPageUI.PASSWORD_TEXBOX);
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXBOX, password);
	}

	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		waitForElementClickable(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXBOX);
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXBOX, confirmPassword);	
	}

	public String getEmailSuccessMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public UserHomePageObject clickToLogoutButton() {
		waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);	
		return PageGeneratorManager.getHomePage(driver);
	}

	public String getEmailExistingMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_EXISTING_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_EXISTING_ERROR_MESSAGE);
	}

}
