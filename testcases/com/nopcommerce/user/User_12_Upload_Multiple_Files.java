package com.nopcommerce.user;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.pageGeneratorManager;

public class User_12_Upload_Multiple_Files extends BaseTest {
	HomePageObject homePage;
	String Screenshot1 = "Screenshot1.png";
	String Screenshot2 = "Screenshot2.png";
	String Screenshot3 = "Screenshot3.png";
	String[] multipleFileNames = {Screenshot1, Screenshot2, Screenshot3};

	  @Parameters({"envName", "serverName", "browser" , "osName", "osVersion"})
	  @BeforeClass
	  public void beforeClass(@Optional("local") String envName, @Optional("DEV") String serverName,@Optional("chrome") String browserName,@Optional("Windows") String osName,@Optional("10") String osVersion) {
		  driver = getBrowserDriver(envName, serverName, browserName, osName, osVersion);
	  homePage = pageGeneratorManager.getHomePage(driver);
  }

@Test
  public void Upload_01_One_File_Per_Time() {
	homePage.upLoadMultipleFiles(driver, Screenshot1);
	assertTrue(homePage.isFileLoadedByName(Screenshot1));
	
	homePage.clickToStartButton();
	assertTrue(homePage.isFileLinkUploadByName(Screenshot1));
	assertTrue(homePage.isFileImageUploadByName(Screenshot1));
  }
  
  @Test
  public void Upload_02_Multiple_Files_Per_Time() {
	  homePage.refeshCurrentPage(driver);
	  homePage.upLoadMultipleFiles(driver, multipleFileNames);
	  assertTrue(homePage.isFileLoadedByName(Screenshot1));
	  assertTrue(homePage.isFileLoadedByName(Screenshot2));
	  assertTrue(homePage.isFileLoadedByName(Screenshot3));
		
	  homePage.clickToStartButton();
	  assertTrue(homePage.isFileLinkUploadByName(Screenshot1));
	  assertTrue(homePage.isFileLinkUploadByName(Screenshot2));
	  assertTrue(homePage.isFileLinkUploadByName(Screenshot3));
	  
	  assertTrue(homePage.isFileImageUploadByName(Screenshot1));
	  assertTrue(homePage.isFileImageUploadByName(Screenshot2));
	  assertTrue(homePage.isFileImageUploadByName(Screenshot3));

  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  private WebDriver driver;

}
