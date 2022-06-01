package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;

public class User_05_Multiple_Browser extends BaseTest {
	private WebDriver driver;	
	private String emailaddress,firstname,lastname,password,confirmpassword,invalidpassword,invalidemail;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
 
	  emailaddress = "frameworkdpv_" + generateNumber() + "@yopmail.com";
	  firstname = "A";
	  lastname = "T";
	  password = "123456";
	  confirmpassword = "123456";
	  invalidpassword = "123";
	  invalidemail = "test@";
	  
	  driver.get("https://demo.nopcommerce.com");
	  
	  homePage = new UserHomePageObject(driver);
	  registerPage = new UserRegisterPageObject(driver);  
  }
	
  @Test
  public void TC_01_Register_With_Empty_Data() {
	  
	  System.out.println("Home Page - Step 01: Click to Register link");
	  homePage.openRegisterPage();
	  
	  System.out.println("Register Page - Step 02: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextBox(),"First name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextBox(),"Last name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(),"Email is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(),"Password is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(),"Password is required.");
  }
  
  @Test
  public void TC_02_Register_Invalid_Email() {
	  
	  System.out.println("Home Page - Step 01: Click to Register link");
	  homePage.openRegisterPage();
	  
	  System.out.println("Register Page - Step 02: Input Data");
	  registerPage.inputToFirstNameTextBox(firstname);
	  registerPage.inputToLastNameTextBox(lastname);
	  registerPage.inputToEmailTextBox(invalidemail);
	  registerPage.inputToPasswordTextBox(password);
	  registerPage.inputToConfirmPasswordTextBox(confirmpassword);
	  
	  System.out.println("Register Page - Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register Page - Step 04: Verify Error Message");
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(),"Wrong email");
	  
  }

  
  public void TC_03_Register_With_Valid_Information() { 
	  
	  System.out.println("Home Page - Step 01: Click to Register link");
	  homePage.openRegisterPage();
	  
	  System.out.println("Register Page - Step 02: Input Data");
	  registerPage.inputToFirstNameTextBox(firstname);
	  registerPage.inputToLastNameTextBox(lastname);
	  registerPage.inputToEmailTextBox(emailaddress);
	  registerPage.inputToPasswordTextBox(password);
	  registerPage.inputToConfirmPasswordTextBox(confirmpassword);
	  
	  System.out.println("Register Page - Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	 
	  System.out.println("Register Page - Step 04: Verify Error Message");
	  assertEquals(registerPage.getEmailSuccessMessage(), "Your registration completed");
	  
	  System.out.println("Register Page - Step 05: Click to Logout button");
	  registerPage.clickToLogoutButton();
  }
 
  
  public void TC_04_Register_With_Email_Existed() {
	  System.out.println("Home Page - Step 01: Click to Register link");
	  homePage.openRegisterPage();
	  
	  System.out.println("Register Page - Step 02: Input Data");
	  registerPage.inputToFirstNameTextBox(firstname);
	  registerPage.inputToLastNameTextBox(lastname);
	  registerPage.inputToEmailTextBox(emailaddress);
	  registerPage.inputToPasswordTextBox(password);
	  registerPage.inputToConfirmPasswordTextBox(confirmpassword);
	  
	  System.out.println("Register Page - Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register Page - Step 04: Verify Error Message");
	  assertEquals(registerPage.getEmailExistingMessage(), "The specified email already exists");

  }
 
 
  public void TC_05_Register_Password_Less_Than_6_Characters() {
	  System.out.println("Home Page - Step 01: Click to Register link");
	  homePage.openRegisterPage();
	  
	  System.out.println("Register Page - Step 02: Input Data");
	  registerPage.inputToFirstNameTextBox(firstname);
	  registerPage.inputToLastNameTextBox(lastname);
	  registerPage.inputToEmailTextBox(emailaddress);
	  registerPage.inputToPasswordTextBox(invalidpassword);
	  registerPage.inputToConfirmPasswordTextBox(confirmpassword);
	  
	  System.out.println("Register Page - Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register Page - Step 04: Verify Error Message");
	  assertEquals(registerPage.getErrorMessageAtPasswordTextBox(), "Password must meet the following rules:\nmust have at least 6 characters");
	  
  }
  
  
  public void TC_06_Register_With_Incorrect_Confirm_Password() {
	  System.out.println("Home Page - Step 01: Click to Register link");
	  homePage.openRegisterPage();
	  
	  System.out.println("Register Page - Step 02: Input Data");
	  registerPage.inputToFirstNameTextBox(firstname);
	  registerPage.inputToLastNameTextBox(lastname);
	  registerPage.inputToEmailTextBox(emailaddress);
	  registerPage.inputToPasswordTextBox(password);
	  registerPage.inputToConfirmPasswordTextBox(invalidpassword);
	  
	  System.out.println("Register Page - Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  System.out.println("Register Page - Step 04: Verify Error Message");
	  assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(), "The password and confirmation password do not match.");
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
