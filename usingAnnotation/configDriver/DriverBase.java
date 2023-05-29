package usingAnnotation.configDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverBase {
	public static WebDriver buildSetupDriver() {
		String pathGecko = "/home/vu.thi.tran.van/vanvtt/QA-CEV/repo/AutomationTestExample/src/main/lib/firefox/geckodriver";
		System.setProperty("webdriver.gecko.driver", pathGecko);
		return (WebDriver) new FirefoxDriver();
	}
}
