package com.nopcommerce.user;


import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObject.jQuery.AdminDashBoardPageObject;
import pageObject.jQuery.AdminLoginPageObject;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.MyAccountPageObject;
import pageObject.jQuery.RegisterPageObject;
import pageObject.jQuery.pageGeneratorManager;

public class User_Practice_11_DataTable_DataGrid_II extends BaseTest {
	HomePageObject homePage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashBoardPageObject adminDashBoardPage;
	String emailaddress, firstname, lastname, password, confirmpassword, adminUserName, adminPassword;

	  @Parameters({"envName", "serverName", "browser" , "osName", "osVersion", "ipAddress", "portNumber"})
	  @BeforeClass
	  public void beforeClass(@Optional("local") String envName, @Optional("DEV") String serverName,@Optional("chrome") String browserName,@Optional("Windows") String osName,@Optional("10") String osVersion, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
		  driver = getBrowserDriver(envName, serverName, browserName, osName, osVersion, ipAddress, portNumber);
	  homePage = pageGeneratorManager.getHomePage(driver);
	  emailaddress = "frameworkdpv_" + generateNumber() + "@yopmail.com";
	  System.out.println(emailaddress);
	  firstname = "A";
	  lastname = "T";
	  password = "123456";
	  confirmpassword = "123456";
	  adminUserName = "user01";
	  adminPassword = "guru99com";
  }

  private int generateNumber() {
	  Random number = new Random();
	  return number.nextInt(9999);
  }

@Test
  public void TC_01_Register_Account_User_Role() {
	registerPage = homePage.clickToRegisterLink();
	registerPage.inputToFirstNameTextBox(firstname);
	registerPage.inputToLastNameTextBox(lastname);
	registerPage.inputToEmailTextBox(emailaddress);
	registerPage.inputToPasswordTextBox(password);
	registerPage.inputToConfirmPasswordTextBox(confirmpassword);
	
	myAccountPage = registerPage.clickToRegisterButton();
  }
  
  @Test
  public void TC_02_Login_Admin_Role() {
	  myAccountPage.openPageURL(driver, GlobalConstants.getGlobalConstants().getAdminLiveGuru());
	  adminLoginPage = pageGeneratorManager.getAdminLoginPage(driver);
	  
	  adminDashBoardPage = adminLoginPage.loginAccount(adminUserName, adminPassword);
	  adminDashBoardPage.clickToClosePopup();
	  adminDashBoardPage.enterToTextBox(emailaddress);
	  adminDashBoardPage.clickToSearchButton();
	  assertEquals(adminDashBoardPage.getEmailAddress(emailaddress), emailaddress);
	  System.out.println(adminDashBoardPage.getEmailAddress(emailaddress));
	  adminDashBoardPage.sleepInSecond(3);
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  private WebDriver driver;

}
