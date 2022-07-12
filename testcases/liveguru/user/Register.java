package liveguru.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveguru.DashBoardPageObject;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginPageObject;
import pageObjects.liveguru.PageGeneratorManager;
import pageObjects.liveguru.RegisterPageObject;

public class Register extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private DashBoardPageObject DashboardPage;
	String emailaddress,firstname,lastname,password,confirmpassword,emailuser;
	
	  @Parameters({"envName", "serverName", "browser" , "osName", "osVersion", "ipAddress", "portNumber"})
	  @BeforeClass
	  public void beforeClass(@Optional("local") String envName, @Optional("DEV") String serverName,@Optional("chrome") String browserName,@Optional("Windows") String osName,@Optional("10") String osVersion, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
		  driver = getBrowserDriver(envName, serverName, browserName, osName, osVersion, ipAddress, portNumber);
		  homePage = PageGeneratorManager.getHomepage(driver);
		  
		  firstname = "AT";
		  lastname = "Last";
		  password = "Admin@123";
		  confirmpassword = "Admin@123";
		  emailaddress = "frameworkdpv_" + generateNumber() + "@yopmail.com";
	  }
	 
	 @Test
	 public void Register_01_Valid_Email() {
		 loginPage = homePage.clickToMyAccountLink();
		 registerPage = loginPage.clickToRegisterButton();
		 registerPage.inputAtFristNameTextBox(firstname);
		 registerPage.inputAtLastNameTextBox(lastname);
		 registerPage.inputAtEmailTextBox(emailaddress);
		 registerPage.inputAtPasswordTextBox(password);
		 registerPage.inputAtConfirmPasswordTextBox(confirmpassword);
		 DashboardPage = registerPage.clickToRegisterButton();
		 emailuser = DashboardPage.getEmailAddress();
		 Assert.assertTrue(emailuser.contains(emailaddress));
		 Assert.assertEquals(DashboardPage.verifySuccessMessage(), "MY DASHBOARD");
		 DashboardPage.clickToMyAccountLink();
		 homePage = DashboardPage.clickToLogOutLink();
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
