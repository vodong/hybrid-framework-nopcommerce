package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputAtFristNameTextBox(String firstname) {
		waitForElementClickable(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstname);
	}

	public void inputAtLastNameTextBox(String lastname) {
		waitForElementClickable(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastname);
	}

	public void inputAtEmailTextBox(String emailaddress) {
		waitForElementClickable(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailaddress);
	}

	public void inputAtPasswordTextBox(String password) {
		waitForElementClickable(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputAtConfirmPasswordTextBox(String confirmpassword) {
		waitForElementClickable(driver, RegisterPageUI.CONFIRM_PASSWOR_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWOR_TEXTBOX, confirmpassword);
	}

	public DashBoardPageObject clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getDashboarPage(driver);
	}

}
