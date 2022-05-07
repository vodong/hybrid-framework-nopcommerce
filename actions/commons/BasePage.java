package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopcommerce.Admin.AdminLoginPageObject;
import pageObjects.nopcommerce.User.UserAddressPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.User.UserRewardPointPageObject;
import pageUIs.nopcommerce.user.BasePageUI;

public class BasePage {
	
	public static BasePage getBasePageObject() {
		return new BasePage();
	}
	
	public void openPageURL(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refeshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait expliciWait = new WebDriverWait(driver, 30);
		return expliciWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}
	
	public void switchtowindowbytitle (WebDriver driver, String expectedtitle) {
		Set<String> Allwindows = driver.getWindowHandles();
		
		for (String id : Allwindows) {
			if(!id.equals(expectedtitle)) {
				driver.switchTo().window(id);			
				String actualtitle = driver.getTitle();
				if(actualtitle.equals(expectedtitle))
					break;
			}
		}
	}
	
	protected void switchtowindowbylink (WebDriver driver, String expectedrelativelink) {
		Set<String> Allwindows = driver.getWindowHandles();
		
		for (String id : Allwindows) {
			if(!id.equals(expectedrelativelink)) {
				driver.switchTo().window(id);			

				String actuallink = driver.getCurrentUrl();
				if(actuallink.equals(expectedrelativelink))
					break;
			}
		}
	}
	
	protected void CloseAllWindownsWithoutParent (WebDriver driver, String parentid) {

			Set<String> Allwindows = driver.getWindowHandles();
			
			for (String id : Allwindows) {
				if(!id.equals(parentid)) {
					driver.switchTo().window(id);			
					driver.close();
				}
			}
			driver.switchTo().window(parentid);
		}
	
	private By getByXpath (String locator) {
		return By.xpath(locator);
	}
	
	private WebElement getWebElement (WebDriver driver, String xpathLocator) {
		return driver.findElement(getByXpath(xpathLocator));
	}
	
	private List<WebElement> getListWebElements (WebDriver driver, String xpathLocator) {
		return driver.findElements(getByXpath(xpathLocator));
	}
	
	protected void clickToElement (WebDriver driver, String xpathLocator) {
		getWebElement(driver, xpathLocator).click();
	}
	
	protected void sendkeyToElement (WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}
	
	protected String getElementText (WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}
	
	protected void selectIteminDefaultDropDownList (WebDriver driver, String xpathLocator, String textitem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByValue(textitem);
	}
	
	protected String getFirstSelectedItemDefaultDropdown (WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	
	protected boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}
	
	protected void selectitemindropdownlist (WebDriver driver, String parentXpath, String childXpath, String expectectTextItem) {
			getWebElement(driver, parentXpath).click();
			sleepInSecond(1);

			WebDriverWait explicitWait = new WebDriverWait(driver, 30);

			List <WebElement> allitems =  explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
			
			for (WebElement item : allitems) {		
				if(item.getText().trim().equals(expectectTextItem)) {	
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
					sleepInSecond(1);
					item.click();
					break;
					}
				}
		}
	
	protected String getElementAttribute(WebDriver driver, String xpathLocator, String attibuteName) {
		return getWebElement(driver, xpathLocator).getAttribute(attibuteName);
	}
	
	protected String getCssValue(WebDriver driver, String xpathLocator, String propertyName) {
		return getWebElement(driver, xpathLocator).getCssValue(propertyName);
	}
	
	protected String covertRgbaToHex(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	protected int getElementSize (WebDriver driver, String xpathLocator) {
		return getListWebElements(driver, xpathLocator).size();
	}
	
	protected void checkToDefaultCheckBoxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(!element.isSelected()) {
			element.click();
		}	
	}
	
	protected void uncheckToDefaultCheckBoxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(element.isSelected()) {
			element.click();
		}	
	}
	
	protected boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}
	
	protected boolean isElementEnabled(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}
	
	protected boolean isElementSelected(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}
	
	protected void switchToFrameIframe(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}
	
	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	protected void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	}

	protected void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void highlightElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, xpathLocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	protected void clickToElementByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
	}

	protected void scrollToElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
	}

	protected void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
	}

	protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	protected String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
	}

	protected boolean isImageLoaded(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, xpathLocator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	protected void waitForElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
	protected void waitForAllElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}
	
	protected void waitForElementInVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
	protected void waitForAllElementInVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, xpathLocator)));
	}
	
	protected void waitForElementClickable(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}
	
	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
		clickToElement(driver, BasePageUI.ADDRESS_LINK);
		return PageGeneratorManager.getAddressPage(driver);
	}
	
	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getMyProductReviewPage(driver);
	}
	
	public UserRewardPointPageObject openRewardwPointPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.REWARD_POINT_LINK);
		clickToElement(driver, BasePageUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getRewardwPointPage(driver);
	}
	
	public UserHomePageObject clickToLogOutLinkAtUserRole(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK_USER);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_USER);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	public AdminLoginPageObject clickToLogOutLinkAtAdminRole(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK_ADMIN);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_ADMIN);
		return PageGeneratorManager.getadminLoginPage(driver);
	}

	

	public void sleepInSecond (long second) {
		try {
			Thread.sleep(second *1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
}

}
