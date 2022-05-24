package com.facebook.register;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObject.Facebook.LoginPageObject;

public class User_14_Element_Undisplayed extends BaseTest {
	private WebDriver driver;
	LoginPageObject loginPage;

  @Parameters({"browser", "url"})
  @BeforeClass
  public void beforeClass(String browserName, String appUrl) {
	  driver = getBrowserDriver(browserName, appUrl);
	  loginPage = pageGeneratorManager.getLoginPage(driver);
  }
  
  @Test
  public void TC_01_Verify_Element_Displayed() { 
	  loginPage.clickToCreteNewAccountButton();
	  
	  loginPage.enterToEmailAddressTextbox("testautomation@yopmail.com");
	  loginPage.sleepInSecond(3);
	  verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());
  }
  
  @Test
  public void TC_02_Verify_Element_Undisplayed_In_DOM() {   
	  loginPage.enterToEmailAddressTextbox("");
	  loginPage.sleepInSecond(3);
	  verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
  }

  @Test
  public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() { 
	  loginPage.clickToCloseIconAtRegisterForm();
	  loginPage.sleepInSecond(3);
	  
	  verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
