package usingAnnotation.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import usingAnnotation.pageObjects.VibloPage;

public class LoginVibloPageTestCase {
	VibloPage vibloPage = null;

	@BeforeSuite
	public void initializePage() {
		vibloPage = new VibloPage();
	}

	@Test
	public void tC1_CheckLoginPage() {

		vibloPage.clickButtonDangNhap();

		String expectedTitle = "Viblo - Login";
		String actualTitle = vibloPage.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Test
	public void tC2_CheckRequireAllItem() throws Exception {

		vibloPage.clickButtonDangNhap();

		WebElement userError = vibloPage.getUserError();
		WebElement passwordError = vibloPage.getPassError();
		vibloPage.waitVisible(10, userError);
		vibloPage.waitVisible(10, passwordError);

		Assert.assertEquals(userError.getText(), "Tên người dùng/email là bắt buộc");
		Assert.assertEquals(passwordError.getText(), "Mật khẩu là bắt buộc");

	}

	 @Test
	public void tC3_CheckRequireUserItem() throws Exception {
		 
		vibloPage.setPassWordInput("abc123");
		
		vibloPage.clickButtonDangNhap();
		
		vibloPage.waitVisible(10, vibloPage.getUserError());
		Assert.assertEquals(vibloPage.getUserError().getText(), "Tên người dùng/email là bắt buộc");
		
		
		List<WebElement> listOfElements = vibloPage.getDriver().findElements(By.xpath("//div[@class='el-form-item__error']"));
	    System.out.println("Number of elements:" +listOfElements.size());

		Assert.assertEquals(listOfElements.size(), 1);
		Thread.sleep(2000);

	}
	@Test
	public void tC4_CheckRequirePassWordItem() throws Exception {

		
		vibloPage.setUserInput("sonlk");
		vibloPage.clearData(vibloPage.getPassWordInput());

		vibloPage.clickButtonDangNhap();
		
		vibloPage.waitVisible(10, vibloPage.getPassError());
		Assert.assertEquals(vibloPage.getPassError().getText(), "Mật khẩu là bắt buộc");
		
		List<WebElement> listOfElements = vibloPage.getDriver().findElements(By.xpath("//div[@class='el-form-item__error']"));
	    System.out.println("Number of elements:" +listOfElements.size());

		Assert.assertEquals(listOfElements.size(), 1);
		
		Thread.sleep(2000);
	}
	
	@Test
	public void tC5_CheckLoginSuccess() throws Exception {

		vibloPage.setUserInput("sonlk");
		vibloPage.setPassWordInput("15091992h");
		vibloPage.clickButtonDangNhap();
		

		vibloPage.waitVisible(10, vibloPage.getAccountInfo());

		
		String expectedTitle = "Viblo Accounts";
		String actualTitle = vibloPage.getDriver().getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		Thread.sleep(2000);
	}
	@AfterSuite
	public void closeBrowser() {
		vibloPage.quitDriver();
		// TODO Auto-generated method stub
	}

}
