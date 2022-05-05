package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);	
	}

	public String getErrorMessageAtFirstNameTextBox() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextBox() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextBox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextBox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirstNameTextBox(String firstName) {
		waitForElementClickable(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
		
	}

	public void inputToLastNameTextBox(String lastName) {
		waitForElementClickable(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);	
	}

	public void inputToEmailTextBox(String email) {
		waitForElementClickable(driver, RegisterPageUI.EMAIL_TEXBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXBOX, email);	
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementClickable(driver, RegisterPageUI.PASSWORD_TEXBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXBOX, password);
	}

	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		waitForElementClickable(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXBOX, confirmPassword);	
	}

	public String getEmailSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public void clickToLogoutButton() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);		
	}

	public String getEmailExistingMessage() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_EXISTING_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_EXISTING_ERROR_MESSAGE);
	}

}
