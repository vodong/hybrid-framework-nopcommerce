package pageObjects.nopcommerce.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopcommerce.admin.AdminLoginPageUI;
import pageUIs.nopcommerce.user.UserHomePageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputEmailTextBox(String emailAdderss) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAdderss);
	}

	public void inputPasswordTextBox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}
	

	public void clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
	}
	
	public AdminDashBoardObject loginAsAdmin(String emailAdderss, String password) {
		inputEmailTextBox(emailAdderss);
		inputPasswordTextBox(password);
		clickToLoginButton();
		return PageGeneratorManager.getadminDashBoardPage(driver);
	}
}
