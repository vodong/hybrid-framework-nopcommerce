package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;

public class User_15_log_ReportNG extends BaseTest {
	private WebDriver driver;
	private String emailaddress,firstname,lastname,password,confirmpassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfor;

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
	  log.info("Register - Step 01: Open Register page");
	  registerPage = homePage.clickToRegisterLink();
	  
	  log.info("Register - Step 02: Enter To Firstname textbox with value '" + firstname + "'");
	  registerPage.inputToFirstNameTextBox(firstname);
	  
	  log.info("Register - Step 03: Enter To Lastname textbox with value '" + lastname + "'");
	  registerPage.inputToLastNameTextBox(lastname);
	  
	  log.info("Register - Step 04: Enter To Email textbox with value '" + emailaddress + "'");
	  registerPage.inputToEmailTextBox(emailaddress);
	  
	  log.info("Register - Step 05: Enter To Password textbox with value '" + password + "'");
	  registerPage.inputToPasswordTextBox(password);
	  
	  log.info("Register - Step 06: Enter To Confirm Password textbox with value '" + confirmpassword + "'");
	  registerPage.inputToConfirmPasswordTextBox(confirmpassword);
	  
	  log.info("Register - Step 07: Click to 'Register' button");
	  registerPage.clickToRegisterButton();
	  
	  log.info("Register - Step 08: Verify Register success message is displayed");
	  verifyEquals(registerPage.getEmailSuccessMessage(), "Your registration completed...");
	  
	  log.info("Register - Step 09: Click to Logout link");
	  homePage = registerPage.clickToLogoutButton();	  
  }

  @Test
  public void TC_02_Login() { 
	  log.info("Login - Step 01: Navigate to Login page");
	  loginPage = homePage.clickToLoginLink();
	  
	  log.info("Login - Step 02: Enter To Email textbox with value '" + emailaddress + "'");
	  loginPage.inputToEmailTextBox(emailaddress);
	  
	  log.info("Login - Step 03: Enter To Password textbox with value '" + password + "'");
	  loginPage.inputToPasswordTextBox(password);
	  
	  log.info("Login - Step 04: Click to 'Login' button");
	  homePage = loginPage.clickToLoginButton();
	  
	  log.info("Login - Step 05: Verify 'My Account' link is displayed");
	  verifyFalse(homePage.isMyAccountLinkDisplay()); //verifyTrue
	  
	  log.info("Login - Step 06: Navigation to My Account page");
	  customerInfor = homePage.clickMyAccountLink();
	  
	  log.info("Login - Step 07: Verify 'Customer Infor' page is displayed");
	  verifyFalse(customerInfor.isMyAccountPageDisplay()); //verifyTrue
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
