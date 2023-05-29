package demo.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import demo.objects.VibloPageObjects;

/*
 * Test với expected
 * gọi từng theo tác theo mô tả testcase  như click btn/ send value/ check message
 * -> gọi tương ứng các thao tác đã tạo sẵn ở PAGE cụ thể
 * Nhớ khởi tạo instance PAGE cụ thể để dùng
 * 
 */
public class VibloPageTestcases {

	VibloPageObjects vibloPage = null;

	@BeforeSuite
	public void initializeDriver() throws Exception {

		// Create object of HomePage Class
		vibloPage = new VibloPageObjects();
	}
	
	@Test
	public void tC1_CheckLoginPage() throws Exception {
		
		String expectedTitle = "Viblo - Login";
		String actualTitle = vibloPage.driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

	}
	@Test
	public void tC2_CheckRequireAllItem() throws Exception {
		
		WebElement dangNhapButton = vibloPage.findTxtObject("ByXpath", "//button[@class='el-button w-100 el-button--primary']");
		WebDriverWait wait = new WebDriverWait(vibloPage.driver, 20);
		wait.until(ExpectedConditions.visibilityOf(dangNhapButton));
		vibloPage.clickButton(dangNhapButton);
		
		WebElement userError = vibloPage.findTxtObject("ByXpath", "//*[contains(text(),'Tên người dùng/email là bắt buộc')]");
		WebElement passError = vibloPage.findTxtObject("ByXpath", "//*[contains(text(),'Mật khẩu là bắt buộc')]");
		
		Assert.assertEquals(userError.getText(), "Tên người dùng/email là bắt buộc");
		Assert.assertEquals(passError.getText(), "Mật khẩu là bắt buộc");
		
		Thread.sleep(2000);
	}
	@Test
	public void tC3_CheckRequireUserItem() throws Exception {

		WebElement dangNhapButton = vibloPage.findTxtObject("ByXpath", "//button[@class='el-button w-100 el-button--primary']");
		WebElement passWordTextBox = vibloPage.findTxtObject("ByXpath", "//input[@type='password']");
		vibloPage.sendKeyForObject(passWordTextBox, "abc123123");
		
		vibloPage.clickButton(dangNhapButton);
		
		WebElement userError = vibloPage.findTxtObject("ByXpath", "//*[contains(text(),'Tên người dùng/email là bắt buộc')]");		
		Assert.assertEquals(userError.getText(), "Tên người dùng/email là bắt buộc");
		List<WebElement> listOfElements = vibloPage.driver.findElements(By.xpath("//div[@class='el-form-item__error']"));
	    System.out.println("Number of elements:" +listOfElements.size());

		Assert.assertEquals(listOfElements.size(), 1);
		Thread.sleep(2000);

	}
	@Test
	public void tC4_CheckRequirePassWordItem() throws Exception {

		WebElement dangNhapButton = vibloPage.findTxtObject("ByXpath", "//button[@class='el-button w-100 el-button--primary']");
		WebElement userTextBox = vibloPage.findTxtObject("ByXpath", "//input[@type='text']");
		WebElement passWordTextBox = vibloPage.findTxtObject("ByXpath", "//input[@type='password']");

		vibloPage.clearData(passWordTextBox);
		vibloPage.sendKeyForObject(userTextBox, "sonlk");
		vibloPage.clickButton(dangNhapButton);
		WebElement passError = vibloPage.findTxtObject("ByXpath", "//*[contains(text(),'Mật khẩu là bắt buộc')]");
		
		List<WebElement> listOfElements = vibloPage.driver.findElements(By.xpath("//div[@class='el-form-item__error']"));
	    System.out.println("Number of elements:" +listOfElements.size());

		Assert.assertEquals(listOfElements.size(), 1);
		Assert.assertEquals(passError.getText(), "Mật khẩu là bắt buộc");
		
		Thread.sleep(2000);
	}
	
	@Test
	public void tC5_CheckLoginSuccess() throws Exception {

		WebElement dangNhapButton = vibloPage.findTxtObject("ByXpath", "//button[@class='el-button w-100 el-button--primary']");
		WebElement userTextBox = vibloPage.findTxtObject("ByXpath", "//input[@type='text']");
		WebElement passWordTextBox = vibloPage.findTxtObject("ByXpath", "//input[@type='password']");

		vibloPage.clearData(passWordTextBox);
		vibloPage.clearData(userTextBox);

		vibloPage.sendKeyForObject(userTextBox, "sonlk");
		vibloPage.sendKeyForObject(passWordTextBox, "15091992h");

		vibloPage.clickButton(dangNhapButton);
		
		WebDriverWait wait = new WebDriverWait(vibloPage.driver, 20);
		WebElement element = vibloPage.findTxtObject("ByXpath", "//*[contains(text(),'Chào mừng, Le Khac Son')]");

		wait.until(ExpectedConditions.visibilityOf(element));
		
		String expectedTitle = "Viblo Accounts";
		String actualTitle = vibloPage.driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		Thread.sleep(2000);
	}


	@AfterClass
	public void quitDriver() {
	  if(vibloPage.driver != null) {
		  vibloPage.driver.quit();
	  }

	}
}
