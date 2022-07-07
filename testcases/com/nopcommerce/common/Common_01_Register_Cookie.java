package com.nopcommerce.common;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;

public class Common_01_Register_Cookie extends BaseTest {
	private WebDriver driver;
	private String firstname,lastname, emailaddress, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	public static Set<Cookie> loggedCookies;

	  @Parameters({"envName", "serverName", "browser" , "osName", "osVersion", "ipAddress", "portNumber"})
	  @BeforeClass
	  public void beforeClass(@Optional("local") String envName, @Optional("DEV") String serverName,@Optional("chrome") String browserName,@Optional("Windows") String osName,@Optional("10") String osVersion, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
		  driver = getBrowserDriver(envName, serverName, browserName, osName, osVersion, ipAddress, portNumber);
	  homePage = PageGeneratorManager.getHomePage(driver);

	  emailaddress = "frameworkdpv_" + generateNumber() + "@yopmail.com";
	  System.out.println(emailaddress);
	  firstname = "A";
	  lastname = "T";
	  password = "123456";
	  
	  log.info("Register - Step 01: Open Register page");
	  registerPage = homePage.openRegisterPage();
	  
	  log.info("Register - Step 02: Enter To Firstname textbox with value '" + firstname + "'");
	  registerPage.inputToFirstNameTextBox(firstname);
	  
	  log.info("Register - Step 03: Enter To Lastname textbox with value '" + lastname + "'");
	  registerPage.inputToLastNameTextBox(lastname);
	  
	  log.info("Register - Step 04: Enter To Email textbox with value '" + emailaddress + "'");
	  registerPage.inputToEmailTextBox(emailaddress);
	  
	  log.info("Register - Step 05: Enter To Password textbox with value '" + password + "'");
	  registerPage.inputToPasswordTextBox(password);
	  
	  log.info("Register - Step 06: Enter To Confirm Password textbox with value '" + password + "'");
	  registerPage.inputToConfirmPasswordTextBox(password);
	  
	  log.info("Register - Step 07: Click to 'Register' button");
	  registerPage.clickToRegisterButton();
	  
	  log.info("Register - Step 08: Verify Register success message is displayed");
	  verifyEquals(registerPage.getEmailSuccessMessage(), "Your registration completed");
	  
	  log.info("Register - Step 09: Click to Logout link");
	  homePage = registerPage.clickToLogoutButton();	 
	  
	  log.info("Login - Step 10: Navigate to Login page");
	  loginPage = homePage.openLoginPage();
	  
	  log.info("Login - Step 11: Enter To Email textbox with value '" + emailaddress + "'");
	  loginPage.inputToEmailTextBox(emailaddress);
	  
	  log.info("Login - Step 12: Enter To Password textbox with value '" + password + "'");
	  loginPage.inputToPasswordTextBox(password);
	  
	  log.info("Login - Step 13: Click to 'Login' button");
	  homePage = loginPage.clickToLoginButton();
	  
	  loggedCookies = homePage.getAllCookies(driver);
	  
	  driver.quit();
  }
  
  public int generateNumber() {
	  Random number = new Random();
	  return number.nextInt(9999);
  }

}
