package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserAddressPageObject;
import pageObjects.nopcommerce.User.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;
import pageObjects.nopcommerce.User.UserRewardPointPageObject;

public class User_09_Dynamic_Locator extends BaseTest {
	private WebDriver driver;
	private String emailaddress,firstname,lastname,password,confirmpassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfor;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;
	

  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
	  homePage = PageGeneratorManager.getHomePage(driver);

	  emailaddress = "frameworkdpv_" + generateNumber() + "@yopmail.com";
	  System.out.println(emailaddress);
	  firstname = "A";
	  lastname = "T";
	  password = "123456";
	  confirmpassword = "123456";
  }

  @Test
  public void TC_01_Register_Login() { 
	  registerPage = homePage.clickToRegisterLink();
	  
	  registerPage.inputToFirstNameTextBox(firstname);
	  registerPage.inputToLastNameTextBox(lastname);
	  registerPage.inputToEmailTextBox(emailaddress);
	  registerPage.inputToPasswordTextBox(password);
	  registerPage.inputToConfirmPasswordTextBox(confirmpassword);
	  
	  registerPage.clickToRegisterButton();
	 
	  assertEquals(registerPage.getEmailSuccessMessage(), "Your registration completed");
	  
	  registerPage.clickToLogoutButton();
	  loginPage = homePage.clickToLoginLink();
	  
	  loginPage.inputToEmailTextBox(emailaddress);
	  loginPage.inputToPasswordTextBox(password);
	  
	  homePage = loginPage.clickToLoginButton();
	  Assert.assertTrue(homePage.isMyAccountLinkDisplay());
	  
	  customerInfor = homePage.clickMyAccountLink();
	  Assert.assertTrue(customerInfor.isMyAccountPageDisplay());
  }
  
  @Test
  public void TC_02_Dynamic_Page_01() {
	  customerInfor.openMyAccountByMyAccountPageName(driver, "Addresses");
	  addressPage = PageGeneratorManager.getAddressPage(driver);

	  addressPage.openMyAccountByMyAccountPageName(driver, "My product reviews");
	  myProductReviewPage = PageGeneratorManager.getMyProductReviewPage(driver);
	  
	  myProductReviewPage.openMyAccountByMyAccountPageName(driver, "Reward points");
	  rewardPointPage = PageGeneratorManager.getRewardwPointPage(driver);
	  
	  rewardPointPage.openMyAccountByMyAccountPageName(driver, "Addresses");
	  addressPage = PageGeneratorManager.getAddressPage(driver);
	  
	  addressPage.openMyAccountByMyAccountPageName(driver, "Reward points");
	  rewardPointPage = PageGeneratorManager.getRewardwPointPage(driver);
	  
	  rewardPointPage.openMyAccountByMyAccountPageName(driver, "My product reviews");
	  myProductReviewPage = PageGeneratorManager.getMyProductReviewPage(driver);
	  
	  myProductReviewPage.openMyAccountByMyAccountPageName(driver, "Addresses");
	  addressPage = PageGeneratorManager.getAddressPage(driver);
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public int generateNumber() {
	  Random number = new Random();
	  return number.nextInt(9999);
  }

}
