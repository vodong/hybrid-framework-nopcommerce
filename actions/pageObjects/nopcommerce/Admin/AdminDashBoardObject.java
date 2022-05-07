package pageObjects.nopcommerce.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.admin.AdminDashboardPageUI;
import pageUIs.nopcommerce.user.UserHomePageUI;

public class AdminDashBoardObject extends BasePage {
	private WebDriver driver;

	public AdminDashBoardObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayDashBoardTitle() {
		waitForElementVisible(driver, AdminDashboardPageUI.DASHBOARD_TITLE);
		return isElementDisplayed(driver, AdminDashboardPageUI.DASHBOARD_TITLE);
	}

}
