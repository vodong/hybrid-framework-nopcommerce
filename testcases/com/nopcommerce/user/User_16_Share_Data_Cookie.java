package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;
import com.nopcommerce.common.Common_01_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;

public class User_16_Share_Data_Cookie extends BaseTest {
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
	  
	  log.info("Pre-Condition - Step 01: Navigate to Login page");
	  loginPage = homePage.clickToLoginLink();
	  
	  log.info("Pre-Condition - Step 02: Set cookie and reload page");
	  loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);
	  loginPage.refeshCurrentPage(driver);
	  
	  log.info("Pre-Condition - Step 03: Verify 'My Account' link is displayed");
	  verifyTrue(homePage.isMyAccountLinkDisplay());
  }
  
  @Test
  public void Search_01_Empty_Data() { 
	  
  }
  
  @Test
  public void Search_02_Relative_Product_Name() { 
	  
  }
  
  @Test
  public void Search_03_Absolute_Product_Name() { 
	  
  }
  
  @Test
  public void Search_04_Parent_Category() { 
	  
  }
  
  @Test
  public void Search_05_Incorrect_Manufactorer() { 
	  
  }
  
  @Test
  public void Search_06_Correct_Manufactorer() { 

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
