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
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class User_03_Page_Object extends BasePage {
	  private WebDriver driver;
	  private String projectPath = System.getProperty("user.dir");
	  private String emailaddress,firstname,lastname,password;
	  private HomePageObject homePage;
	  private RegisterPageObject registerPage;


  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", projectPath + "\\browserdrivers\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com");
	  driver.manage().window().maximize();
	  
	  homePage = new HomePageObject(driver);
	  registerPage = new RegisterPageObject(driver);
	  
	  firstname = "Test";
	  lastname = "AT";
	  password = "123456";
	  emailaddress = "frameworkdpv_" + generateNumber() + "@yopmail.com";	  
  }
	
  @Test
  public void TC_01_Register_With_Empty_Data() {
	  
	  homePage.clickToRegisterLink();
	  registerPage.clickToRegisterButton();
	  
	  Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(),"First name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(),"Last name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Email is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"Password is required.");
  }
  
  @Test
  public void TC_02_Register_Invalid_Email() {

	  homePage.clickToRegisterLink();
	  
	  registerPage.inputToFirstnameTextbox(lastname);
	  registerPage.inputToLastnameTextbox(firstname);
	  registerPage.inputToEmailTextbox("tes112312");
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  registerPage.clickToRegisterButton();
	  
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Wrong email"); 
  }

  @Test
  public void TC_03_Register_With_Valid_Information() { 
	  
	  homePage.clickToRegisterLink();
	  
	  registerPage.inputToFirstnameTextbox(lastname);
	  registerPage.inputToLastnameTextbox(firstname);
	  registerPage.inputToEmailTextbox(emailaddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  registerPage.clickToRegisterButton();
	 
	  assertEquals(registerPage.getMessageRegisterEmaiSuccessfull(), "Your registration completed");
	  
	  registerPage.clickToLogoutButton();
  }
 
  @Test
  public void TC_04_Register_With_Email_Existed() {
	  homePage.clickToRegisterLink();
	  
	  registerPage.inputToFirstnameTextbox(lastname);
	  registerPage.inputToLastnameTextbox(firstname);
	  registerPage.inputToEmailTextbox(emailaddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  registerPage.clickToRegisterButton();
	  
	  assertEquals(registerPage.getErrorMessageEmailExisted(), "The specified email already exists");
  }
  
  @Test
  public void TC_05_Register_Password_Less_Than_6_Characters() {
	  
	  homePage.clickToRegisterLink();
	  
	  registerPage.inputToFirstnameTextbox(lastname);
	  registerPage.inputToLastnameTextbox(firstname);
	  registerPage.inputToEmailTextbox(emailaddress);
	  registerPage.inputToPasswordTextbox("123");
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  registerPage.clickToRegisterButton();
	  
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password must meet the following rules:\nmust have at least 6 characters");
  }
  
  @Test
  public void TC_06_Register_With_Incorrect_Confirm_Password() {
	  
	  homePage.clickToRegisterLink();
	  
	  registerPage.inputToFirstnameTextbox(lastname);
	  registerPage.inputToLastnameTextbox(firstname);
	  registerPage.inputToEmailTextbox(emailaddress);
	  registerPage.inputToPasswordTextbox("123456789");
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  registerPage.clickToRegisterButton();

	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"The password and confirmation password do not match.");
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
