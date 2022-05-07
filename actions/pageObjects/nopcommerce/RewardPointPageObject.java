package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.HomePageUI;
import pageUIs.nopcommerce.MyAccountPageUI;

public class RewardPointPageObject extends BasePage {
	private WebDriver driver;

	public RewardPointPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyAccountPageDisplay() {
		waitForElementVisible(driver, MyAccountPageUI.CUSTOMER_INFO_TITLE);
		return isElementDisplayed(driver, MyAccountPageUI.CUSTOMER_INFO_TITLE);
	}

}
