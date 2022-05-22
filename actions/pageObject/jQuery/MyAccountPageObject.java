package pageObject.jQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class MyAccountPageObject extends BasePage {
	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextBoxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL,Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER_ACTIVED, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER_ACTIVED, pageNumber);
	}

	public List<String> getAllTotalPaginationNumber() {
		int TotalPagingNumber = getElementSize(driver, HomePageUI.TOTAL_PAGINATION_NUMBER);
		System.out.println("Total size: " + TotalPagingNumber);
		
		List<String> allRowValuesAllPage = new ArrayList<String>();
		
		// Set không được lưu trùng
//		Set<String> allRowValuesUniqueAllPage = new HashSet<String>();
		
		//Duyet qua tat ca cac page
		for (int index = 1; index <= TotalPagingNumber; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_BY_INDEX, String.valueOf(index));
			
			//List<WebElement> allRowElemtnEachPage = getListWebElements(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			List<WebElement> allRowElemtnEachPage = getListWebElements(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
			
			//Get text của all row mỗi page đưa vào ArrayList
			for (WebElement eachRow : allRowElemtnEachPage) {
				allRowValuesAllPage.add(eachRow.getText());
			}
		}
		
		//In tất cả giá trị row ra - tất cả các page
		for (String text : allRowValuesAllPage) {
			//System.out.println("-------------------------");
			System.out.println(text);
		}
		
		return allRowValuesAllPage;
	}

	public void enterToTextBoxAtRowNumberByColumnName(String columnName, String rowNumber, String textValue) {
		int totalColumnName = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementVisible(driver, HomePageUI.ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(totalColumnName));
		sendkeyToElement(driver, HomePageUI.ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, textValue, rowNumber, String.valueOf(totalColumnName));
		
	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String textValue) {
		int totalColumnName = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementClickable(driver, HomePageUI.DROP_DOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(totalColumnName));
		selectIteminDefaultDropDownList(driver, HomePageUI.DROP_DOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, textValue, rowNumber, String.valueOf(totalColumnName));
		
	}

	public void clickToDemoLoadDataButton() {
		waitForElementClickable(driver, HomePageUI.DEMO_LOAD_DATA_BUTTON);
		clickToElement(driver, HomePageUI.DEMO_LOAD_DATA_BUTTON);
		
	}

	public void checkToCheckBoxAtRowNumberByColumnName(String columnName, String rowNumber) {
		int totalColumnName = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECK_BOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(totalColumnName));
		checkToDefaultCheckBoxOrRadio(driver, HomePageUI.CHECK_BOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(totalColumnName));
		
	}

	public void unCheckToCheckBoxAtRowNumberByColumnName(String columnName, String rowNumber) {
		int totalColumnName = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECK_BOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(totalColumnName));
		uncheckToDefaultCheckBoxRadio(driver, HomePageUI.CHECK_BOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(totalColumnName));
		
	}

	public void clickToIconByRownNumber(String rowNumber, String textValue) {
		waitForElementClickable(driver, HomePageUI.ICON_NAME_BY_ROW_INDEX, rowNumber, textValue);
		clickToElement(driver, HomePageUI.ICON_NAME_BY_ROW_INDEX, rowNumber, textValue);
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.CREATE_ACCOUNT_BUTTON);
		clickToElement(driver, HomePageUI.CREATE_ACCOUNT_BUTTON);
		return null;
	}
}
