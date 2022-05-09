package javaBasic;

public class Topic_StringFormat {
	public static final String ADDRESS_LINK = "div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK = "div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static final String CUSTOMER_INFO = "//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	
	// 1 biến cho cả 14 page hoặc n page (format giống nhau - chỉ khác nhau bởi tên page)
	public static String DYNAMIC_SIDER_LINK_BY_PAGE_NAME = "//div[contains(@class,'account-navigation')]//a[text()='%s']";
	
	// 1 locator để đại diện cho các page (Header/ Siderbar/ Footer)
	public static String DYNAMIC_FOOT_LINK_BY_PAGE_NAME = "//div[contains(@class,'%s')]//a[text()='%s']";
	
	public static void main(String[] args) {
		clickToLink(ADDRESS_LINK);
		
		clickToLink(DYNAMIC_SIDER_LINK_BY_PAGE_NAME, "My product reviews");
		
		clickToLink(DYNAMIC_FOOT_LINK_BY_PAGE_NAME, "account-navigation", "Addresses");	
	}
	
	public static void clickToLink(String locator) {
		System.out.println("Click to: " + locator);
	}
	
	public static void clickToLink(String dynamicLocator, String pagename) {
		String locator = String.format(dynamicLocator, pagename);
		System.out.println("Click to: " + locator);
	}
	
	public static void clickToLink(String dynamicLocator, String areaName, String pagename) {
		String locator = String.format(dynamicLocator, areaName, pagename);
		System.out.println("Click to: " + locator);
	}

}
