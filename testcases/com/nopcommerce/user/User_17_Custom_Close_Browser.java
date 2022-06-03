package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;

public class User_17_Custom_Close_Browser extends BaseTest {
	private WebDriver driver;
	private String emailaddress,password;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
	  homePage = PageGeneratorManager.getHomePage(driver);
	  
	  emailaddress = Common_01_Register_End_User.emailaddress;
	  password = Common_01_Register_End_User.password;
	  
	  log.info("Login - Step 01: Navigate to Login page");
	  loginPage = homePage.clickToLoginLink();
	  
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

  @AfterClass(alwaysRun = true)
  public void afterClass() {
	  closeBrowserAndDriver();
  }
  
  public int generateNumber() {
	  Random number = new Random();
	  return number.nextInt(9999);
  }

}
