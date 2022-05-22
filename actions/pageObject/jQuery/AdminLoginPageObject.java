package pageObject.jQuery;


import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputUsername(String username) {
		waitForElementClickable(driver, AdminLoginPageUI.USER_NAME_TEXT_BOX);
		sendkeyToElement(driver, AdminLoginPageUI.USER_NAME_TEXT_BOX, username);
	}
	
	public void inputPassword(String password) {
		waitForElementClickable(driver, AdminLoginPageUI.PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXT_BOX, password);
	}
	
	public void clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
	}

	public AdminDashBoardPageObject loginAccount(String adminUserName, String adminPassword) {
		inputUsername(adminUserName);
		inputPassword(adminPassword);
		clickToLoginButton();
		return pageGeneratorManager.getAdminDashBoard(driver);
	}

}
