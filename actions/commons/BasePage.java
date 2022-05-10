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
import pageObjects.nopcommerce.User.UserHomePageObject;
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
	
	private By getByLocator (String locatorType) {
		By by = null;
		if(locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if(locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		}else if(locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		}else if(locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		}else if(locatorType.startsWith("xpath") || locatorType.startsWith("XPATH") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
			by = By.xpath(locatorType.substring(6));
		}else {
			throw new RuntimeException("Locator type is not supported!");
		}
		return by;
	}
	
	private String getDynamicElement(String locatorType, String... values) {
		if(locatorType.startsWith("xpath") || locatorType.startsWith("XPATH") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
			locatorType = String.format(locatorType, (Object[]) values);
		} else if(locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			locatorType = String.format(locatorType, (Object[]) values);
		} else if(locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
			locatorType = String.format(locatorType, (Object[]) values);
		}else if(locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
			locatorType = String.format(locatorType, (Object[]) values);
		}else if(locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			locatorType = String.format(locatorType, (Object[]) values);
		}
		return locatorType;
	}

	private WebElement getWebElement (WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}
	
	private List<WebElement> getListWebElements (WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}
	
	protected void clickToElement (WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}
	
	protected void clickToElement (WebDriver driver, String locatorType, String... dynamicValue) {
		getWebElement(driver, getDynamicElement(locatorType, dynamicValue)).click();
	}
	
	protected void sendkeyToElement (WebDriver driver, String locatorType, String textValue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}
	
	protected void sendkeyToElement (WebDriver driver, String locatorType, String textValue, String... dynamicValue) {
		WebElement element = getWebElement(driver, getDynamicElement(locatorType, dynamicValue));
		element.clear();
		element.sendKeys(textValue);
	}
	
	protected String getElementText (WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}
	
	
	protected String getElementText (WebDriver driver, String locatorType, String... dynamicValue) {
		return getWebElement(driver, getDynamicElement(locatorType, dynamicValue)).getText();
	}
	
	protected void selectIteminDefaultDropDownList (WebDriver driver, String locatorType, String textitem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByValue(textitem);
	}
	
	protected void selectIteminDefaultDropDownList (WebDriver driver, String locatorType, String textitem, String... dynamicValue) {
		Select select = new Select(getWebElement(driver, getDynamicElement(locatorType, dynamicValue)));
		select.selectByValue(textitem);
	}
	
	protected String getFirstSelectedItemDefaultDropdown (WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}
	
	protected String getFirstSelectedItemDefaultDropdown (WebDriver driver, String locatorType, String... dynamicValue) {
		Select select = new Select(getWebElement(driver, getDynamicElement(locatorType, dynamicValue)));
		return select.getFirstSelectedOption().getText();
	}
	
	protected boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}
	
	protected boolean isDropdownMultiple(WebDriver driver, String locatorType, String... dynamicValue) {
		Select select = new Select(getWebElement(driver, getDynamicElement(locatorType, dynamicValue)));
		return select.isMultiple();
	}
	
	protected void selectitemindropdownlist (WebDriver driver, String parentXpath, String childXpath, String expectectTextItem) {
		getWebElement(driver, parentXpath).click();
		sleepInSecond(1);
		
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		
		List <WebElement> allitems =  explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
		
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
	
	protected String getElementAttribute(WebDriver driver, String locatorType, String attibuteName) {
		return getWebElement(driver, locatorType).getAttribute(attibuteName);
	}
	
	protected String getCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}
	
	protected String getCssValue(WebDriver driver, String locatorType, String propertyName, String... dynamicValue) {
		return getWebElement(driver, getDynamicElement(locatorType, dynamicValue)).getCssValue(propertyName);
	}
	
	protected String covertRgbaToHex(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	protected int getElementSize (WebDriver driver, String locatorType) {
		return getListWebElements(driver, locatorType).size();
	}
	
	protected int getElementSize (WebDriver driver, String locatorType, String... dynamicValue) {
		return getListWebElements(driver, getDynamicElement(locatorType, dynamicValue)).size();
	}
	
	protected void checkToDefaultCheckBoxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if(!element.isSelected()) {
			element.click();
		}	
	}
	
	protected void uncheckToDefaultCheckBoxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if(element.isSelected()) {
			element.click();
		}	
	}
	
	protected boolean isElementDisplayed(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isDisplayed();
	}
	
	
	protected boolean isElementDisplayed(WebDriver driver, String locatorType, String... dynamicValue) {
		return getWebElement(driver, getDynamicElement(locatorType, dynamicValue)).isDisplayed();
	}

	protected boolean isElementEnabled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}
	
	protected boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}
	
	protected void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}
	
	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	protected void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	protected void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}
	
	protected void highlightElement(WebDriver driver, String locatorType, String... dynamicValue) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, getDynamicElement(locatorType, dynamicValue));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}
	
	protected void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	protected void clickToElementByJS(WebDriver driver, String locatorType, String... dynamicValue) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, getDynamicElement(locatorType, dynamicValue)));
	}

	protected void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	protected void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
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

	protected String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	protected boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	protected void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}
		
	protected void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicElement(locatorType, dynamicValue))));
	}
	
	protected void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}
	
	protected void waitForAllElementVisible(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicElement(locatorType, dynamicValue))));
	}
	
	protected void waitForElementInVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	protected void waitForAllElementInVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, locatorType)));
	}
	
	protected void waitForAllElementInVisible(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, getDynamicElement(locatorType, dynamicValue))));
	}
	
	
	protected void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}
	
	protected void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicElement(locatorType, dynamicValue))));
	}
	
	public void openMyAccountByMyAccountPageName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_SIDER_LINK_BY_PAGE_NAME, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_SIDER_LINK_BY_PAGE_NAME, pageName);
	}
	
	public void openMyAccountByFooterPageName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_FOOT_LINK_BY_PAGE_NAME, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_FOOT_LINK_BY_PAGE_NAME, pageName);
	}
	
//	public UserAddressPageObject openAddressPage(WebDriver driver) {
//		waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
//		clickToElement(driver, BasePageUI.ADDRESS_LINK);
//		return PageGeneratorManager.getAddressPage(driver);
//	}
//	
//	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
//		waitForElementClickable(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
//		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
//		return PageGeneratorManager.getMyProductReviewPage(driver);
//	}
//	
//	public UserRewardPointPageObject openRewardwPointPage(WebDriver driver) {
//		waitForElementClickable(driver, BasePageUI.REWARD_POINT_LINK);
//		clickToElement(driver, BasePageUI.REWARD_POINT_LINK);
//		return PageGeneratorManager.getRewardwPointPage(driver);
//	}
	
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
