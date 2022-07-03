package com.nopcommerce.common;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;

public class Common_01_Register_End_User extends BaseTest {
	private WebDriver driver;
	private String firstname,lastname;
	public static String emailaddress, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

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
	  driver.quit();
  }
  
  public int generateNumber() {
	  Random number = new Random();
	  return number.nextInt(9999);
  }

}
