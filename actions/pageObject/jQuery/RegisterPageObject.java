package pageObject.jQuery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstNameTextBox(String firstname) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX, firstname);
	}

	public void inputToLastNameTextBox(String lastname) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXT_BOX, lastname);
	}

	public void inputToEmailTextBox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXT_BOX, email);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXT_BOX, password);
	}

	public void inputToConfirmPasswordTextBox(String confirmpassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX, confirmpassword);	
	}

	public MyAccountPageObject clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return pageGeneratorManager.getMyAccountPage(driver);
	}

}
