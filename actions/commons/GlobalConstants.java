package commons;

import java.io.File;

import lombok.Getter;

@Getter
public class GlobalConstants {
//<<<<<<< HEAD
//	public static final String PORTAL_DEV_URL = "https://demo.nopcommerce.com/";
//	public static final String ADMIN_DEV_URL = "https://admin-demo.nopcommerce.com/login";
//	public static final String PORTAL_TESTING_URL = "https://demo.nopcommerce.com/";
//	public static final String ADMIN_TESTING_URL = "https://admin-demo.nopcommerce.com/login";
//	public static final String PROJECT_PATH = System.getProperty("user.dir");
//	public static final String JAVA_VERSION = System.getProperty("java.version");
//	public static final String OS_NAME = System.getProperty("os.name");
//	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
//	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
//	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs" + File.separator;
//	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
//	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
//	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;
//=======
	private static GlobalConstants globalInstance;
//>>>>>>> branch 'vodong/hybrid-framework-nopcommerce' of https://github.com/vodong/hybrid-framework-nopcommerce
	
	public static synchronized GlobalConstants getGlobalConstants() {
		if(globalInstance == null) {
			globalInstance = new GlobalConstants();
		}
		return globalInstance;
	}

	private final String devAppUrl = "https://demo.nopcommerce.com/";
	private final String adminAppUrl = "https://admin-demo.nopcommerce.com/login";
	private final String testAppUrl = "https://demo.nopcommerce.com/";
	private final String adminTestAppUrl = "https://admin-demo.nopcommerce.com/login";
	private final String projectPath = System.getProperty("user.dir");
	private final String javaVersion = System.getProperty("java.version");
	private final String osName = System.getProperty("os.name");
	private final String uploadFile = projectPath + File.separator + "uploadFiles" + File.separator;
	private final String downloadFile = projectPath + File.separator + "downloadFiles";
	private final String browserLog = projectPath + File.separator + "browserLogs" + File.separator;
	private final String dragDropHtml5 = projectPath + File.separator + "dragDropHTML5";
	private final String autoITScript = projectPath + File.separator + "autoIT";
	private final String reportScreenshot = projectPath + File.separator + "reportNGImages" + File.separator;
	
	private final long shortTimeout = 5;
	private final long longTimeout = 30;
	private final long retryTestfail = 3;
	
	private final String adminLiveGuru = "http://live.techpanda.org/index.php/backendlogin/customer/";
	
	private final String browserStackUsername = "vodongpham_vbRLlM";
	private final String browserStackKey = "idztyWmBznShx8tLvKAe";
	private final String browserStackUrl = "https://" + browserStackUsername + ":" + browserStackKey + "@hub-cloud.browserstack.com/wd/hub";
}
