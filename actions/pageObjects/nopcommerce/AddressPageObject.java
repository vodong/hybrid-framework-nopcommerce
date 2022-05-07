package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.BasePageUI;

public class AddressPageObject extends BasePage {
	private WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
