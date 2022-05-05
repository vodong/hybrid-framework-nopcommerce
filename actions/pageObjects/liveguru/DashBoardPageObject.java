package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.DashBoardPageUI;

public class DashBoardPageObject extends BasePage {
	private WebDriver driver;

	public DashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String verifySuccessMessage() {
		waitForElementVisible(driver, DashBoardPageUI.PAGE_TITLE);
		return getElementText(driver, DashBoardPageUI.PAGE_TITLE);
	}

	public String getEmailAddress() {
		waitForElementVisible(driver, DashBoardPageUI.CONTACT_INFORMATION);
		return getElementText(driver, DashBoardPageUI.CONTACT_INFORMATION);
	}

	public void clickToMyAccountLink() {
		waitForElementClickable(driver, DashBoardPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, DashBoardPageUI.MY_ACCOUNT_LINK);
	}

	public HomePageObject clickToLogOutLink() {
		waitForElementClickable(driver, DashBoardPageUI.LOG_OUT_LINK);
		clickToElement(driver, DashBoardPageUI.LOG_OUT_LINK);
		return PageGeneratorManager.getHomepage(driver);
	}

}
