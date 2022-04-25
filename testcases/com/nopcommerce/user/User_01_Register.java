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

public class User_01_Register {
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
	  driver.findElement(By.cssSelector("a.ico-register")).click();
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(),"First name is required.");
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(),"Last name is required.");
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(),"Email is required.");
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(),"Password is required.");
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),"Password is required.");  
  }
  
  @Test
  public void TC_02_Register_Invalid_Email() {
	  driver.findElement(By.cssSelector("a.ico-register")).click();
	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Test");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("AT");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys("tes112312");
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123456789");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456789");
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(),"Wrong email");
	  
	  driver.findElement(By.cssSelector("button#register-button")).click();
  }
  @Test
  public void TC_03_Register_With_Valid_Information() { 
	  driver.findElement(By.cssSelector("a.ico-register")).click();
	  driver.findElement(By.cssSelector("span.male")).click();
	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Test");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("AT");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys(emailaddress);
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123456789");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456789");
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
	  
	  driver.findElement(By.cssSelector("a.ico-logout")).click();
  }
  @Test
  public void TC_04_Register_With_Email_Existed() {
	  driver.findElement(By.cssSelector("a.ico-register")).click();
	  driver.findElement(By.cssSelector("span.male")).click();
	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Test");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("AT");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys(emailaddress);
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123456789");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456789");
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error")).getText(), "The specified email already exists");
	  
	  
	  
  }
  @Test
  public void TC_05_Register_Password_Less_Than_6_Characters() {
	  driver.findElement(By.cssSelector("a.ico-register")).click();
	  driver.findElement(By.cssSelector("span.male")).click();
	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Test");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("AT");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys(emailaddress);
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456789");
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password must meet the following rules:\nmust have at least 6 characters");
 
  }
  @Test
  public void TC_06_Register_With_Incorrect_Confirm_Password() {
	  driver.findElement(By.cssSelector("a.ico-register")).click();
	  driver.findElement(By.cssSelector("span.male")).click();
	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Test");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("AT");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys(emailaddress);
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123456789");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("12345");
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");
	  
	  
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
