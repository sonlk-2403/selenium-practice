package usingAnnotation.testcases;

import org.testng.annotations.Test;

import usingAnnotation.configDriver.DriverBase;
import usingAnnotation.pageObjects.GithubPage;

public class LoginGitHubTestCase extends DriverBase {

	/*
	 * Viết các testcase ở đây code khởi tạo object từ Github page sau này có nhiều
	 * testcase thì chúng ta sẽ đưa vào 1 method và sử dụng chung cho all testcase
	 * tại page này với annotation là @BeforeClass
	 */
	@Test
	public void allowSetDataForEmailAndPasswordField() throws Exception {
		GithubPage githubPage = new GithubPage();
		Thread.sleep(1000);

		githubPage.clickButtonSignIn();
		githubPage.sendValueEmailField("email.com");
		githubPage.sendValuePasswordField("1234");
	}
}
