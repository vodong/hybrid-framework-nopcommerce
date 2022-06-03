package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class User_15_log_ReportNGV5 extends BaseTest {
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
  public void TC_01_Register(Method method) { 
	  ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
	  ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Open Register page");

	  registerPage = homePage.openRegisterPage();

	  ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter To Firstname textbox with value '" + firstname + "'");
	  registerPage.inputToFirstNameTextBox(firstname);

	  ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter To Lastname textbox with value '" + lastname + "'");
	  registerPage.inputToLastNameTextBox(lastname);
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter To Email textbox with value '" + emailaddress + "'");
	  registerPage.inputToEmailTextBox(emailaddress);
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter To Password textbox with value '" + password + "'");
	  registerPage.inputToPasswordTextBox(password);
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter To Confirm Password textbox with value '" + confirmpassword + "'");
	  registerPage.inputToConfirmPasswordTextBox(confirmpassword);

	  ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to 'Register' button");
	  registerPage.clickToRegisterButton();
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify Register success message is displayed");
	  assertEquals(registerPage.getEmailSuccessMessage(), "Your registration completed...");
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Register - Step 09: Click to Logout link");
	  homePage = registerPage.clickToLogoutButton();	  
  }

  @Test
  public void TC_02_Login(Method method) { 
	  ExtentTestManager.startTest(method.getName(), "Login to system with valid Email and Password");
	  ExtentTestManager.getTest().log(Status.INFO,"Login - Step 01: Navigate to Login page");
	  loginPage = homePage.openLoginPage();
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter To Email textbox with value '" + emailaddress + "'");
	  loginPage.inputToEmailTextBox(emailaddress);
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter To Password textbox with value '" + password + "'");
	  loginPage.inputToPasswordTextBox(password);
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to 'Login' button");
	  homePage = loginPage.clickToLoginButton();
	  ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
	  assertFalse(homePage.isMyAccountLinkDisplay()); //verifyTrue
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Login - Step 06: Navigation to My Account page");
	  customerInfor = homePage.clickMyAccountLink();
	  ExtentTestManager.getTest().log(Status.INFO, "Login - Step 07: Verify 'Customer Infor' page is displayed");
	  assertFalse(customerInfor.isMyAccountPageDisplay()); //verifyTrue
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
