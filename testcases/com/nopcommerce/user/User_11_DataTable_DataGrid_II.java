package com.nopcommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.pageGeneratorManager;

public class User_11_DataTable_DataGrid_II extends BaseTest {
	HomePageObject homePage;
	List<String> actualAllValues;
	List<String> expectedAllValues;

	  @Parameters({"envName", "serverName", "browser" , "osName", "osVersion", "ipAddress", "portNumber"})
	  @BeforeClass
	  public void beforeClass(@Optional("local") String envName, @Optional("DEV") String serverName,@Optional("chrome") String browserName,@Optional("Windows") String osName,@Optional("10") String osVersion, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
		  driver = getBrowserDriver(envName, serverName, browserName, osName, osVersion, ipAddress, portNumber);
	  homePage = pageGeneratorManager.getHomePage(driver);
  }

  @Test
  public void Table_01_Enter_To_Table() {
	  homePage.clickToDemoLoadDataButton();
	  
	  homePage.enterToTextBoxAtRowNumberByColumnName("Album","1","Michale 97");
	  homePage.enterToTextBoxAtRowNumberByColumnName("Artist","1","Michale 97");
	  homePage.enterToTextBoxAtRowNumberByColumnName("Year","1","1995");
	  homePage.enterToTextBoxAtRowNumberByColumnName("Price","1","150");
	  homePage.selectDropdownByColumnNameAtRowNumber("Origin" , "1" , "Japan");
	  
	  homePage.enterToTextBoxAtRowNumberByColumnName("Album","2","Michale 971");
	  homePage.enterToTextBoxAtRowNumberByColumnName("Artist","2","Michale 927");
	  homePage.enterToTextBoxAtRowNumberByColumnName("Year","2","1985");
	  homePage.enterToTextBoxAtRowNumberByColumnName("Price","2","180");
	  homePage.selectDropdownByColumnNameAtRowNumber("Origin" , "2" , "Hong Kong");
	  
	  homePage.enterToTextBoxAtRowNumberByColumnName("Album","4","Michale 971");
	  homePage.enterToTextBoxAtRowNumberByColumnName("Artist","5","Michale 927");
	  homePage.enterToTextBoxAtRowNumberByColumnName("Year","3","1985");
	  homePage.enterToTextBoxAtRowNumberByColumnName("Price","1","180");
	  homePage.selectDropdownByColumnNameAtRowNumber("Origin" , "5" , "Taiwan");
	  
	  homePage.checkToCheckBoxAtRowNumberByColumnName("With Poster?" ,"3");
	  homePage.checkToCheckBoxAtRowNumberByColumnName("With Poster?" ,"5");
	  
	  homePage.unCheckToCheckBoxAtRowNumberByColumnName("With Poster?" ,"1");
	  homePage.unCheckToCheckBoxAtRowNumberByColumnName("With Poster?" ,"2");
	  homePage.unCheckToCheckBoxAtRowNumberByColumnName("With Poster?" ,"4");

  }
  
  @Test
  public void Table_02_Insert_Row_Remove_Row() {
	  homePage.clickToIconByRownNumber("1", "Remove Current Row");
	  homePage.sleepInSecond(2);
	  
	  homePage.clickToIconByRownNumber("1", "Insert Row Above");
	  homePage.sleepInSecond(2);
	  
	  homePage.clickToIconByRownNumber("3", "Move Up");
	  homePage.sleepInSecond(2);
	  
	  homePage.clickToIconByRownNumber("5", "Remove Current Row");
	  homePage.sleepInSecond(2);
	  
	  homePage.clickToIconByRownNumber("4", "Remove Current Row");
	  homePage.sleepInSecond(2);
	  
	  homePage.clickToIconByRownNumber("3", "Remove Current Row");
	  homePage.sleepInSecond(2);
	  
	  homePage.clickToIconByRownNumber("2", "Remove Current Row");
	  homePage.sleepInSecond(2);
	  
	  homePage.clickToIconByRownNumber("1", "Remove Current Row");
	  homePage.sleepInSecond(2);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  private WebDriver driver;

}
