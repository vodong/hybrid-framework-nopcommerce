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

public class User_10_DataTable_DataGrid_I extends BaseTest {
	HomePageObject homePage;
	List<String> actualAllValues;
	List<String> expectedAllValues;

	  @Parameters({"envName", "serverName", "browser" , "osName", "osVersion"})
	  @BeforeClass
	  public void beforeClass(@Optional("local") String envName, @Optional("DEV") String serverName,@Optional("chrome") String browserName,@Optional("Windows") String osName,@Optional("10") String osVersion) {
		  driver = getBrowserDriver(envName, serverName, browserName, osName, osVersion);
	  homePage = pageGeneratorManager.getHomePage(driver);
  }


  public void Table_01() {
	  homePage.openPagingNumber("10");
	  Assert.assertTrue(homePage.isPageNumberActived("10"));
	  
	  homePage.openPagingNumber("20");
	  Assert.assertTrue(homePage.isPageNumberActived("20"));
	  
	  homePage.openPagingNumber("7");
	  Assert.assertTrue(homePage.isPageNumberActived("7"));
	  
	  homePage.openPagingNumber("18");
	  Assert.assertTrue(homePage.isPageNumberActived("18"));
	  
  }
  
  public void Table_02_Enter_To_Header() {
	  homePage.refeshCurrentPage(driver);
	  
	  homePage.enterToHeaderTextBoxByLabel("Country", "Argentina");
	  homePage.enterToHeaderTextBoxByLabel("Females", "338282");
	  homePage.enterToHeaderTextBoxByLabel("Males", "349238");
	  homePage.enterToHeaderTextBoxByLabel("Total", "687522");
	  
	  homePage.enterToHeaderTextBoxByLabel("Country", "Angola");
	  homePage.enterToHeaderTextBoxByLabel("Females", "376880");
	  homePage.enterToHeaderTextBoxByLabel("Males", "276472");
	  homePage.enterToHeaderTextBoxByLabel("Total", "553353");
 
  }
  
  
  public void Table_03_Enter_To_Header() {
	  // Đọc dữ liệu của file country.txt ra
	  // Lưu vào 1 List<String> = Expected value = expectedAllCountryValues
	  
	  //Actual Value
	  actualAllValues = homePage.getAllTotalPaginationNumber();
	  //Assert.assertEquals(actualAllValues, expectedAllValues);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  private WebDriver driver;

}
