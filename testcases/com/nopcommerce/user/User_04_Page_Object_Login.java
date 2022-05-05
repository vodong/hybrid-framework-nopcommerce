package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.RegisterPageObject;

public class User_04_Page_Object_Login extends BasePage {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String emailaddress,firstname,lastname,password,confirmpassword,invalidemail,emailnotfound,wrongpassword;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", projectPath + "\\browserdrivers\\geckodriver.exe");
	  driver = new FirefoxDriver();

	  emailaddress = "frameworkdpv_" + generateNumber() + "@yopmail.com";
	  firstname = "A";
	  lastname = "T";
	  password = "123456";
	  confirmpassword = "123456";
	  wrongpassword = "1234567";
	  invalidemail = "test@";
	  emailnotfound = "test@yopmail";
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com");
	  
	  homePage = new HomePageObject(driver);
	  registerPage = new RegisterPageObject(driver);
	  loginPage = new LoginPageObject(driver);
	  driver.manage().window().maximize();
	  
	  homePage.clickToRegisterLink();
	  
	  registerPage.inputToFirstNameTextBox(firstname);
	  registerPage.inputToLastNameTextBox(lastname);
	  registerPage.inputToEmailTextBox(emailaddress);
	  registerPage.inputToPasswordTextBox(password);
	  registerPage.inputToConfirmPasswordTextBox(confirmpassword);
	  
	  registerPage.clickToRegisterButton();
	  registerPage.clickToLogoutButton();
  }
	
  @Test
  public void Login_01_With_Empty_Data() {
	  
	  System.out.println("Home Page - Step 01: Click to Login link");
	  homePage.clickToLoginLin();
	  
	  System.out.println("Login Page - Step 02: Click to Login button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login Page - Step 03: Verify Error Message");
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(),"Please enter your email");
  }
  
  @Test
  public void Login_02_Invalid_Email() {
	  
	  System.out.println("Home Page - Step 01: Click to Login link");
	  homePage.clickToLoginLin();
	  
	  System.out.println("Login Page - Step 02: Input Invalid Email");
	  loginPage.inputToEmailTextBox(invalidemail);
	  
	  System.out.println("Login Page - Step 03: Click to Login button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login Page - Step 04: Verify Error Message");
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(),"Wrong email");
	  
  }

  @Test
  public void Login_03_With_Email_Is_Not_Existed() { 
	  
	  System.out.println("Home Page - Step 01: Click to Login link");
	  homePage.clickToLoginLin();
	  
	  System.out.println("Login Page - Step 02: Input Email Is Not Existed");
	  loginPage.inputToEmailTextBox(emailnotfound);
	  loginPage.inputToPasswordTextBox(password);
	  
	  System.out.println("Login Page - Step 03: Click to Login button");
	  loginPage.clickToLoginButton();
	 
	  System.out.println("Login Page - Step 04: Verify Error Message");
	  Assert.assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found"); 
  }
 
  @Test
  public void Login_04_With_Empty_Password() {
	  System.out.println("Home Page - Step 01: Click to Login link");
	  homePage.clickToLoginLin();
	  
	  System.out.println("Login Page - Step 02: Input Email Is Not Existed");
	  loginPage.inputToEmailTextBox(emailaddress);
	  loginPage.inputToPasswordTextBox("");
	  
	  System.out.println("Login Page - Step 03: Click to Login button");
	  loginPage.clickToLoginButton();
	 
	  System.out.println("Login Page - Step 04: Verify Error Message");
	  assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect"); 

  }
 
  @Test
  public void Login_05_With_Wrong_Password() {
	  System.out.println("Home Page - Step 01: Click to Login link");
	  homePage.clickToLoginLin();
	  
	  System.out.println("Login Page - Step 02: Input Email Is Not Existed");
	  loginPage.inputToEmailTextBox(emailaddress);
	  loginPage.inputToPasswordTextBox(wrongpassword);
	  
	  System.out.println("Login Page - Step 03: Click to Login button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login Page - Step 04: Verify Error Message");
	  assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	  
  }
  
  @Test
  public void Login_06_With_Valid_Information() {
	  System.out.println("Home Page - Step 01: Click to Login link");
	  homePage.clickToLoginLin();
	  
	  System.out.println("Login Page - Step 02: Input Email Is Not Existed");
	  loginPage.inputToEmailTextBox(emailaddress);
	  loginPage.inputToPasswordTextBox(password);
	  
	  System.out.println("Login Page - Step 03: Click to Login button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Register Page - Step 04: Verify Login Successfull");
	  assertEquals(homePage.getWelcomeText(), "Welcome to our store");
	  
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
