package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_FIRST_NAME);
		return getElementText(driver, RegisterPageUI.ERROR_MESSAGE_FIRST_NAME);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);	
	}

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstnameTextbox(String textValue) {
		waitForElementClickable(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, textValue);	
	}

	public void inputToLastnameTextbox(String textValue) {
		waitForElementClickable(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, textValue);	
	}

	public void inputToEmailTextbox(String textValue) {
		waitForElementClickable(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, textValue);	
	}

	public void inputToPasswordTextbox(String textValue) {
		waitForElementClickable(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, textValue);	
	}

	public void inputToConfirmPasswordTextbox(String textValue) {
		waitForElementClickable(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, textValue);	
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementInVisible(driver, RegisterPageUI.ERROR_MESSAGE_EMAIL);
		return getElementText(driver, RegisterPageUI.ERROR_MESSAGE_EMAIL);
	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementInVisible(driver, RegisterPageUI.ERROR_MESSAGE_LAST_NAME);
		return getElementText(driver, RegisterPageUI.ERROR_MESSAGE_LAST_NAME);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementInVisible(driver, RegisterPageUI.ERROR_MESSAGE_PASSWORD);
		return getElementText(driver, RegisterPageUI.ERROR_MESSAGE_PASSWORD);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementInVisible(driver, RegisterPageUI.ERROR_MESSAGE_CONFIRM_PASSWORD);
		return getElementText(driver, RegisterPageUI.ERROR_MESSAGE_CONFIRM_PASSWORD);
	}

	public String getMessageRegisterEmaiSuccessfull() {
		waitForElementVisible(driver, RegisterPageUI.MESSAGE_REGISTER_SUCCESSFULL);
		return getElementText(driver, RegisterPageUI.MESSAGE_REGISTER_SUCCESSFULL);
	}

	public void clickToLogoutButton() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_BUTTON);
		clickToElement(driver, RegisterPageUI.LOGOUT_BUTTON);	
	}

	public String getErrorMessageEmailExisted() {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_EMAIL_EXISTED);
		return getElementText(driver, RegisterPageUI.ERROR_MESSAGE_EMAIL_EXISTED);
	}

}
