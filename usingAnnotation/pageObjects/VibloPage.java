package usingAnnotation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import usingAnnotation.configDriver.DriverBase;

public class VibloPage extends BasePageCommon {
	private String accessUrl = "https://accounts.viblo.asia/login";

	@FindBy(how = How.XPATH, using = "//button[@class='el-button w-100 el-button--primary']")
	private WebElement dangNhapButton;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Tên người dùng/email là bắt buộc')]")
	private WebElement userError;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Mật khẩu là bắt buộc')]")
	private WebElement passError;

	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	private WebElement passWordInput;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Chào mừng, Le Khac Son')]")
	private WebElement accountInfo;

	@FindBy(how = How.XPATH, using = "//input[@type='text']")
	private WebElement userInput;

	public VibloPage() {
		// constructor
//		this.driver = DriverBase.buildSetupDriver();
//		this.driver.get(accessUrl);
//		this.driver.manage().window().maximize();
//		PageFactory.initElements(driver, this);

		this.setDriver(DriverBase.buildSetupDriver());
		this.getDriver().get(accessUrl);
		this.getDriver().manage().window().maximize();
		PageFactory.initElements(this.getDriver(), this);
	}

	public void waitVisible(long second, WebElement object) {
		WebDriverWait wait = new WebDriverWait(this.getDriver(), second);
		wait.until(ExpectedConditions.visibilityOf(object));
	}

	public WebElement getDangNhapButton() {
		return dangNhapButton;
	}

	public WebElement getUserError() {
		return userError;
	}

	public WebElement getPassError() {
		return passError;
	}

	// Các thao tác trên page
	public void clickButtonDangNhap() {
		dangNhapButton.click();
	}

	public String getPageTitle() {
		return this.getDriver().getTitle();

	}

	public void setPassWordInput(String password) {
		passWordInput.clear();
		this.passWordInput.sendKeys(password);
	}

	public void setUserInput(String user) {
		userInput.clear();
		this.userInput.sendKeys(user);
	}

	public boolean checkAccount() {
		return accountInfo.getText().toString().contains("Le Khac Son");
	}

	public WebElement getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(WebElement accountInfo) {
		this.accountInfo = accountInfo;
	}

	public WebElement getPassWordInput() {
		return passWordInput;
	}

	public WebElement getUserInput() {
		return userInput;
	}

}
