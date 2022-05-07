package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopcommerce.Admin.AdminDashBoardObject;
import pageObjects.nopcommerce.Admin.AdminLoginPageObject;
import pageObjects.nopcommerce.User.UserAddressPageObject;
import pageObjects.nopcommerce.User.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;
import pageObjects.nopcommerce.User.UserRewardPointPageObject;

public class PageGeneratorManager {
	
	public static UserHomePageObject getHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserRegisterPageObject getRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static UserLoginPageObject getLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserCustomerInfoPageObject getMyAccountPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}

	public static UserAddressPageObject getAddressPage(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}

	public static UserMyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}
	
	public static UserRewardPointPageObject getRewardwPointPage(WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}
	
	public static AdminDashBoardObject getadminDashBoardPage(WebDriver driver) {
		return new AdminDashBoardObject(driver);
	}

	public static AdminLoginPageObject getadminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

}
