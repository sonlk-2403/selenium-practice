package usingAnnotation.configDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverBase {
	public static WebDriver buildSetupDriver() {
		String pathChrome = "C:\\Users\\le.khac.son\\Downloads\\practice-java-selenium-dn-main\\practice-java-selenium-dn-main\\selenium-practice\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", pathChrome);
		return (WebDriver) new ChromeDriver();
	}
}
