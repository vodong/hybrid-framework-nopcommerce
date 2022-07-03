package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
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

public class User_18_Pattern_Object extends BaseTest {
	private WebDriver driver;
	private String emailaddress,firstname,lastname,password,confirmpassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfor;

	  @Parameters({"envName", "serverName", "browser" , "osName", "osVersion"})
	  @BeforeClass
	  public void beforeClass(@Optional("local") String envName, @Optional("DEV") String serverName,@Optional("chrome") String browserName,@Optional("Windows") String osName,@Optional("10") String osVersion) {
		  driver = getBrowserDriver(envName, serverName, browserName, osName, osVersion);
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
	  registerPage.inputToTextBoxByID(driver, "FirstName", firstname);

	  ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter To Lastname textbox with value '" + lastname + "'");
	  registerPage.inputToTextBoxByID(driver, "LastName", lastname);
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter To Email textbox with value '" + emailaddress + "'");
	  registerPage.inputToTextBoxByID(driver, "Email", emailaddress);
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter To Password textbox with value '" + password + "'");
	  registerPage.inputToTextBoxByID(driver, "Password", password);
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter To Confirm Password textbox with value '" + confirmpassword + "'");
	  registerPage.inputToTextBoxByID(driver, "ConfirmPassword", confirmpassword);

	  ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to 'Register' button");
	  registerPage.clickToButtonByText(driver, "Register");
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify Register success message is displayed");
	  assertEquals(registerPage.getEmailSuccessMessage(), "Your registration completed");  
  }

  @Test
  public void TC_02_Login(Method method) { 
	  ExtentTestManager.startTest(method.getName(), "Login to system with valid Email and Password");
	  ExtentTestManager.getTest().log(Status.INFO,"Login - Step 01: Navigate to Login page");
	  homePage = registerPage.clickToLogoutButton();
	  loginPage = homePage.openLoginPage();
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter To Email textbox with value '" + emailaddress + "'");
	  loginPage.inputToTextBoxByID(driver, "Email", emailaddress);
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter To Password textbox with value '" + password + "'");
	  loginPage.inputToTextBoxByID(driver, "Password", password);
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to 'Login' button");
	  loginPage.clickToButtonByText(driver, "Log in");
	  homePage = PageGeneratorManager.getHomePage(driver);
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
	  assertTrue(homePage.isMyAccountLinkDisplay());
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Login - Step 06: Navigation to My Account page");
	  customerInfor = homePage.clickMyAccountLink();
	  
	  ExtentTestManager.getTest().log(Status.INFO, "Login - Step 07: Verify 'Customer Infor' page is displayed");
	  assertTrue(customerInfor.isMyAccountPageDisplay());
  }

  @AfterClass(alwaysRun = true)
  public void afterClass(String envName) {
	  closeBrowserAndDriver(envName);
  }
  
  public int generateNumber() {
	  Random number = new Random();
	  return number.nextInt(9999);
  }

}
