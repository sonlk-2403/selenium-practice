package usingAnnotation.pageObjects;

import org.openqa.selenium.WebDriver;

public class BasePageCommon {
	private WebDriver driver;
	
	// quit driver
	public void quitDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	/*
	 * Defined các method phổ thông tại các page
	 * Ex: find Element, findElements, click, send data, clear, ...
	 */
	
}
