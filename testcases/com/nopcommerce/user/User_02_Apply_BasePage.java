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

public class User_02_Apply_BasePage extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailaddress;

  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", projectPath + "\\browserdrivers\\geckodriver.exe");
	  driver = new FirefoxDriver();

	  emailaddress = "frameworkdpv_" + generateNumber() + "@yopmail.com";
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com");
	  driver.manage().window().maximize();
  }
	
  @Test
  public void TC_01_Register_With_Empty_Data() {
	  
	  waitForElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  waitForElementClickable(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  
	  Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"),"First name is required.");
	  Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"),"Last name is required.");
	  Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"),"Email is required.");
	  Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"),"Password is required.");
	  Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),"Password is required.");
  }
  
  @Test
  public void TC_02_Register_Invalid_Email() {
	  
	  waitForElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  sendkeyToElement(driver, "//input[@id='FirstName']", "Test");
	  sendkeyToElement(driver, "//input[@id='LastName']", "AT");
	  sendkeyToElement(driver, "//input[@id='Email']", "tes112312");
	  sendkeyToElement(driver, "//input[@id='Password']", "123456789");
	  sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456789");
	  Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"),"Wrong email");
	  clickToElement(driver, "//button[@id='register-button']");
  }

  @Test
  public void TC_03_Register_With_Valid_Information() { 
	  
	  waitForElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  sendkeyToElement(driver, "//input[@id='FirstName']", "Test");
	  sendkeyToElement(driver, "//input[@id='LastName']", "AT");
	  sendkeyToElement(driver, "//input[@id='Email']", emailaddress);
	  sendkeyToElement(driver, "//input[@id='Password']", "123456789");
	  sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456789");
	  clickToElement(driver, "//button[@id='register-button']");
	 
	  waitForElementClickable(driver, "//div[@class='result']");
	  assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
	  
	  waitForElementClickable(driver, "//a[@class='ico-logout']");
	  clickToElement(driver, "//a[@class='ico-logout']");
  }
 
  @Test
  public void TC_04_Register_With_Email_Existed() {
	  waitForElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  sendkeyToElement(driver, "//input[@id='FirstName']", "Test");
	  sendkeyToElement(driver, "//input[@id='LastName']", "AT");
	  sendkeyToElement(driver, "//input[@id='Email']", emailaddress);
	  sendkeyToElement(driver, "//input[@id='Password']", "123456789");
	  sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456789");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  waitForElementClickable(driver, "//div[@class='message-error validation-summary-errors']");
	  assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']"), "The specified email already exists");	  
  }
  
  @Test
  public void TC_05_Register_Password_Less_Than_6_Characters() {
	  waitForElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  sendkeyToElement(driver, "//input[@id='FirstName']", "Test");
	  sendkeyToElement(driver, "//input[@id='LastName']", "AT");
	  sendkeyToElement(driver, "//input[@id='Email']", emailaddress);
	  sendkeyToElement(driver, "//input[@id='Password']", "123");
	  sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456789");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  waitForElementClickable(driver, "//span[@id='Password-error']");
	  assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
  }
  
  @Test
  public void TC_06_Register_With_Incorrect_Confirm_Password() {
	  waitForElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  sendkeyToElement(driver, "//input[@id='FirstName']", "Test");
	  sendkeyToElement(driver, "//input[@id='LastName']", "AT");
	  sendkeyToElement(driver, "//input[@id='Email']", emailaddress);
	  sendkeyToElement(driver, "//input[@id='Password']", "123456789");
	  sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "1234567");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  waitForElementClickable(driver, "//span[@id='ConfirmPassword-error']");
	  assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
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
