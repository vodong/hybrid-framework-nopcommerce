package pageUIs.jQuery;

public class AdminDashBoardPageUI {
	public static final String POPUP = "xpath=//div[@id='message-popup-window']//a[@title='close']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//th//span/a/span[text()='%s']/ancestor::tr/following-sibling::tr/th//input[@id='%s']";
	public static final String EMAIL = "xpath=//input[@id='customerGrid_filter_email']";
	public static final String SEARCH_BUTTON = "xpath=//button[@title='Search']";
	//public static final String EMAIL_ADDRESS_AT_ROW_INDEX = "xpath=//tr[@class='even pointer']/td[%s]";
	public static final String EMAIL_ADDRESS_AT_COLUMN_INDEX = "xpath=//tr[@class='even pointer']/td[4]";
}