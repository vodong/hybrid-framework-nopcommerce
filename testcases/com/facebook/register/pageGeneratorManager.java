package com.facebook.register;

import org.openqa.selenium.WebDriver;

import pageObject.Facebook.LoginPageObject;

public class pageGeneratorManager {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
}
