package pageObjects.nopcommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.UserHomePageUI;
import pageUIs.nopcommerce.user.UserMyAccountPageUI;

public class UserRewardPointPageObject extends BasePage {
	private WebDriver driver;

	public UserRewardPointPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyAccountPageDisplay() {
		waitForElementVisible(driver, UserMyAccountPageUI.CUSTOMER_INFO_TITLE);
		return isElementDisplayed(driver, UserMyAccountPageUI.CUSTOMER_INFO_TITLE);
	}

}
