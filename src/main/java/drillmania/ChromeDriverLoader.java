package drillmania;

import java.io.File;

import org.apache.commons.lang.SystemUtils;

public class ChromeDriverLoader {
	public static boolean init() {
		File driver = getDriverBin();
		if(driver!=null&&driver.canExecute()) {
			System.setProperty("webdriver.chrome.driver", driver.getAbsolutePath());
			return true;
		}
		return false;
	}
	
	private static File getDriverBin() {
		if(SystemUtils.IS_OS_MAC_OSX) {
			return new File("src/main/resources/chromedriver_mac64");
		}else if(SystemUtils.IS_OS_WINDOWS) {
			return new File("src/main/resources/chromedriver_win32.exe");
		}else if(SystemUtils.IS_OS_LINUX) {
			return new File("src/main/resources/chromedriver_linux64");
		}
		return null;
	}

}