package usingAnnotation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePageCommon {
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

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
	public void sendKeyForObject(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	// event
	public void clickButton(WebElement element) {
		element.click();
	}
	
	public void clearDataThenSendValue(WebElement object, String value) {
		object.clear();
		object.sendKeys(value);
	}
	public void clearData(WebElement object) {
		object.clear();
	}
	
}
