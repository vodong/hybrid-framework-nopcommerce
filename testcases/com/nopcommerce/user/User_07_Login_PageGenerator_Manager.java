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
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.MyProductReviewPageObject;
import pageObjects.nopcommerce.AddressPageObject;
import pageObjects.nopcommerce.CustomerInfoPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;
import pageObjects.nopcommerce.RewardPointPageObject;

public class User_07_Login_PageGenerator_Manager extends BaseTest {
	private WebDriver driver;
	private String emailaddress,firstname,lastname,password,confirmpassword;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerInfoPageObject customerInfor;
	private AddressPageObject addressPage;
	private MyProductReviewPageObject myProductReviewPage;
	private RewardPointPageObject rewardPointPage;
	

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
	  registerPage = homePage.clickToRegisterLink();
	  
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
	  loginPage = homePage.clickToLoginLink();
	  
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
  
  @Test
  public void TC_04_Switch_Page() {
	  // Customer Infor -> Address
	  addressPage = customerInfor.openAddressPage(driver);
	  
	  // Address -> My Product Review
	  myProductReviewPage = addressPage.openMyProductReviewPage(driver);
	  
	  // My Product Review -> Reward Point
	  rewardPointPage = myProductReviewPage.openRewardwPointPage(driver);
	  
	  // Reward Point -> Address
	  addressPage = rewardPointPage.openAddressPage(driver);
	  
	  // Address -> Reward Point
	  rewardPointPage = addressPage.openRewardwPointPage(driver);
	  
	  // Reward Point -> My Product Review
	  myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
	  
	  // My Product Review -> Address
	  addressPage = myProductReviewPage.openAddressPage(driver);
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
