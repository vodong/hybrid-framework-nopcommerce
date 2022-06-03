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

public class User_07_Login_PageGenerator_Manager extends BaseTest {
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
  public void TC_01_Register() { 
	  
	  System.out.println("TC_01_Register - Step 01: Click to Register link");
	  registerPage = homePage.openRegisterPage();
	  
	  System.out.println("TC_01_Register - Step 02: Input Data");
	  registerPage.inputToFirstNameTextBox(firstname);
	  registerPage.inputToLastNameTextBox(lastname);
	  registerPage.inputToEmailTextBox(emailaddress);
	  registerPage.inputToPasswordTextBox(password);
	  registerPage.inputToConfirmPasswordTextBox(confirmpassword);
	  
	  System.out.println("TC_01_Register - Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	 
	  System.out.println("TC_01_Register - Step 04: Verify Error Message");
	  assertEquals(registerPage.getEmailSuccessMessage(), "Your registration completed");
	  
	  System.out.println("TC_01_Register - Step 05: Click to Logout button");
	  registerPage.clickToLogoutButton();
  }
 
  @Test
  public void TC_02_Login() {
	  System.out.println("TC_02_Login - Step 01: Click to Login link");
	  loginPage = homePage.openLoginPage();
	  
	  System.out.println("TC_02_Login - Step 02: Input Data");
	  loginPage.inputToEmailTextBox(emailaddress);
	  loginPage.inputToPasswordTextBox(password);
	  
	  System.out.println("TC_02_Login - Step 03: Click to Login button");
	  homePage = loginPage.clickToLoginButton();
	  
	  System.out.println("TC_02_Login - Step 04: Verify My Account Link");
	  Assert.assertTrue(homePage.isMyAccountLinkDisplay());

  }
 
  @Test
  public void TC_03_My_Account() {
	  System.out.println("TC_03_My_Account - Step 01: Open My Account Page");
	  customerInfor = homePage.clickMyAccountLink();
	  
	  System.out.println("TC_03_My_Account - Step 02: Verify My Account Page");
	  Assert.assertTrue(customerInfor.isMyAccountPageDisplay());
  }
//  
//  @Test
//  public void TC_04_Switch_Page() {
//	  // Customer Infor -> Address
//	  System.out.println("TC_04 - Step 01: Open Address Page");
//	  addressPage = customerInfor.openAddressPage(driver);
//	  
//	  // Address -> My Product Review
//	  System.out.println("TC_04 - Step 02: Open My Product Review Page");
//	  myProductReviewPage = addressPage.openMyProductReviewPage(driver);
//	  
//	  // My Product Review -> Reward Point
//	  System.out.println("TC_04 - Step 03: Open Reward Point Page");
//	  rewardPointPage = myProductReviewPage.openRewardwPointPage(driver);
//	  
//	  // Reward Point -> Address
//	  System.out.println("TC_04 - Step 04: Open Address Page");
//	  addressPage = rewardPointPage.openAddressPage(driver);
//	  
//	  // Address -> Reward Point
//	  System.out.println("TC_04 - Step 05: Open Reward Point Page");
//	  rewardPointPage = addressPage.openRewardwPointPage(driver);
//	  
//	  // Reward Point -> My Product Review
//	  System.out.println("TC_04 - Step 06: Open Rewadrd Page");
//	  myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
//	  
//	  // My Product Review -> Address
//	  System.out.println("TC_04 - Step 07: Open Address Page");
//	  addressPage = myProductReviewPage.openAddressPage(driver);
//  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public int generateNumber() {
	  Random number = new Random();
	  return number.nextInt(9999);
  }

}
