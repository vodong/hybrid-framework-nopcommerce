package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.Admin.AdminDashBoardObject;
import pageObjects.nopcommerce.Admin.AdminLoginPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;

public class User_08_Switch_Role extends BaseTest {
	private WebDriver driver;
	private String emailaddress,firstname,lastname,password,confirmpassword, adminEmailAddress, adminPassword;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private AdminDashBoardObject adminDashBoardPage;
	private AdminLoginPageObject adminLoginPage;
	

	  @Parameters({"envName", "serverName", "browser" , "osName", "osVersion", "ipAddress", "portNumber"})
	  @BeforeClass
	  public void beforeClass(@Optional("local") String envName, @Optional("DEV") String serverName,@Optional("chrome") String browserName,@Optional("Windows") String osName,@Optional("10") String osVersion, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
		  driver = getBrowserDriver(envName, serverName, browserName, osName, osVersion, ipAddress, portNumber);
	  userHomePage = PageGeneratorManager.getHomePage(driver);

	  emailaddress = "frameworkdpv_" + generateNumber() + "@yopmail.com";
	  System.out.println(emailaddress);
	  firstname = "A";
	  lastname = "T";
	  password = "123456";
	  confirmpassword = "123456";
	  adminEmailAddress = "admin@yourstore.com";
	  adminPassword = "admin";
  }

  @Test
  public void TC_01_Register() { 
	  
	  System.out.println("TC_01_Register - Step 01: Click to Register link");
	  userRegisterPage = userHomePage.openRegisterPage();
	  
	  System.out.println("TC_01_Register - Step 02: Input Data");
	  userRegisterPage.inputToFirstNameTextBox(firstname);
	  userRegisterPage.inputToLastNameTextBox(lastname);
	  userRegisterPage.inputToEmailTextBox(emailaddress);
	  userRegisterPage.inputToPasswordTextBox(password);
	  userRegisterPage.inputToConfirmPasswordTextBox(confirmpassword);
	  
	  System.out.println("TC_01_Register - Step 03: Click to Register button");
	  userRegisterPage.clickToRegisterButton();
	 
	  System.out.println("TC_01_Register - Step 04: Verify Error Message");
	  assertEquals(userRegisterPage.getEmailSuccessMessage(), "Your registration completed");
	  
	  System.out.println("TC_01_Register - Step 05: Click to Logout button");
	  userHomePage = userRegisterPage.clickToLogoutButton();
  }
 
  @Test
  public void TC_02_Role_User_To_Admin() {
	  System.out.println("TC_02_Role_User_To_Admin - Step 01: Click to Login link");
	  userLoginPage = userHomePage.openLoginPage();
	  
	  //Login as User role
	  System.out.println("TC_02_Login - Step 02: Input Data");
	  userHomePage = userLoginPage.loginAsUser(emailaddress, password);
	  
	  System.out.println("TC_02_Login - Step 03: Logout User Role");
	  userHomePage.clickToLogOutLinkAtUserRole(driver);
  }
  
  @Test
  public void TC_03_Role_Admin() {
	  System.out.println("TC_03_Role_Admin - Step 01: Open Login Page");
	  userHomePage.openPageURL(driver, GlobalConstants.getGlobalConstants().getAdminAppUrl());
	  adminLoginPage = PageGeneratorManager.getadminLoginPage(driver);
	  
	  //Login as Admin role
	  System.out.println("TC_03_Role_Admin - Step 02: Input Data");
	  adminDashBoardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
	  
	  Assert.assertTrue(adminDashBoardPage.isDisplayDashBoardTitle());
	  
	  System.out.println("TC_02_Login - Step 03: Logout Admin Role");
	  adminLoginPage = adminDashBoardPage.clickToLogOutLinkAtAdminRole(driver);
  }
 
  @Test
  public void TC_04_Role_Admin_To_User() {
	  System.out.println("TC_04_Role_Admin_To_User - Step 01: Open Login Page");
	  adminLoginPage.openPageURL(driver, GlobalConstants.getGlobalConstants().getDevAppUrl());
	  userHomePage = PageGeneratorManager.getHomePage(driver);
	  
	  //Login as User role
	  System.out.println("TC_03_Role_Admin - Step 03: Open Login Page");
	  userLoginPage = userHomePage.openLoginPage();
	  
	  System.out.println("TC_03_Role_Admin - Step 03: Input Data");
	  userHomePage = userLoginPage.loginAsUser(emailaddress, password);
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
