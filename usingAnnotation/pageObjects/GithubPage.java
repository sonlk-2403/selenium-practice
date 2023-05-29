package usingAnnotation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import usingAnnotation.configDriver.DriverBase;

public class GithubPage extends BasePageCommon {
	private String accessUrl = "https://github.com";
	private WebDriver driver;
	
	@FindBy(how = How.LINK_TEXT, using = "Sign in")
	private WebElement btnSignIn;
	

	@FindBy(id = "login_field")
	private WebElement txtEmail;


	@FindBy(id = "password")
	private WebElement txtPassword;


	public GithubPage() {
		// constructor
		this.driver = DriverBase.buildSetupDriver();
		this.driver.get(accessUrl);
		this.driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	// Các thao tác trên page
	public void clickButtonSignIn() {
		btnSignIn.click();
	}
	
	public void sendValueEmailField(String valueEmail) {
		txtEmail.sendKeys(valueEmail);
	}
	public void sendValuePasswordField(String valuePassword) {
		txtPassword.sendKeys(valuePassword);
	}
	
}
