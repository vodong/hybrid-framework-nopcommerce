package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;

public class User_16_Share_Data extends BaseTest {
	private WebDriver driver;
	private String emailaddress,password;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

	  @Parameters({"envName", "serverName", "browser" , "osName", "osVersion"})
	  @BeforeClass
	  public void beforeClass(@Optional("local") String envName, @Optional("DEV") String serverName,@Optional("chrome") String browserName,@Optional("Windows") String osName,@Optional("10") String osVersion) {
		  driver = getBrowserDriver(envName, serverName, browserName, osName, osVersion);
	  homePage = PageGeneratorManager.getHomePage(driver);
	  
	  emailaddress = Common_01_Register_End_User.emailaddress;
	  password = Common_01_Register_End_User.password;
	  
	  log.info("Login - Step 01: Navigate to Login page");
	  loginPage = homePage.openLoginPage();
	  
	  log.info("Login - Step 02: Enter To Email textbox with value '" + emailaddress + "'");
	  loginPage.inputToEmailTextBox(emailaddress);
	  
	  log.info("Login - Step 03: Enter To Password textbox with value '" + password + "'");
	  loginPage.inputToPasswordTextBox(password);
	  
	  log.info("Login - Step 04: Click to 'Login' button");
	  homePage = loginPage.clickToLoginButton();
  }
  
  @Test
  public void Search_01_Empty_Data() { 
	  
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
