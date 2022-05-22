package pageObject.jQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.AdminDashBoardPageUI;
import pageUIs.jQuery.HomePageUI;

public class AdminDashBoardPageObject extends BasePage {
	WebDriver driver;

	public AdminDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToClosePopup() {
		waitForElementClickable(driver, AdminDashBoardPageUI.POPUP);
		clickToElement(driver, AdminDashBoardPageUI.POPUP);
		
	}

	public void enterToTextBox(String email) {
		waitForElementClickable(driver, AdminDashBoardPageUI.EMAIL);
		sendkeyToElement(driver, AdminDashBoardPageUI.EMAIL, email);	
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminDashBoardPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminDashBoardPageUI.SEARCH_BUTTON);
		
	}

	public String getEmailAddress(String emailAddress) {
		waitForElementVisible(driver, AdminDashBoardPageUI.EMAIL_ADDRESS_AT_COLUMN_INDEX, emailAddress);
		return getElementText(driver, AdminDashBoardPageUI.EMAIL_ADDRESS_AT_COLUMN_INDEX, emailAddress);
	}
}
