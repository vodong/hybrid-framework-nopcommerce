package pageUIs.nopcommerce.user;

public class BasePageUI {
	public static final String ADDRESS_LINK = "XPATH=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK = "XPATH=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "XPATH=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static final String CUSTOMER_INFO = "XPATH=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static final String LOGOUT_LINK_USER = "XPATH=//a[@class='ico-logout']";
	public static final String LOGOUT_LINK_ADMIN ="XPATH=//a[text()='Logout']";
	
	//Pattern Object
	public static String DYNAMIC_SIDER_LINK_BY_PAGE_NAME = "XPATH=//div[contains(@class,'account-navigation')]//a[text()='%s']";	
	public static String DYNAMIC_FOOT_LINK_BY_PAGE_NAME = "XPATH=//div[contains(@class,'%s')]//a[text()='%s']";
	public static String DYNAMIC_TEXTBOX_BY_ID = "XPATH=//input[@id='%s']";
	public static String DYNAMIC_TEXTBOX_BY_NAME = "XPATH=//button[text()='%s']";
}
