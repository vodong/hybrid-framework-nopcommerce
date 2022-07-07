package commons;

import java.io.File;

import lombok.Getter;

@Getter
public class GlobalConstants {
	private static GlobalConstants globalInstance;
	
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
