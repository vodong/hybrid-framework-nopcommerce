package pageObjects.nopcommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.BasePageUI;

public class UserAddressPageObject extends BasePage {
	private WebDriver driver;

	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
