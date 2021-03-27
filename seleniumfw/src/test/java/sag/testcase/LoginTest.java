package sag.testcase;

import static supports.CommonFunctions.getDriver;
import static supports.CommonFunctions.setBrowser;

import org.junit.Test;

import SAG.LoginSAG;
import supports.CommonFunctions;

public class LoginTest {

	@Test
	public void shouldLoginSuccess() throws InterruptedException {
		setBrowser("chrome");

		LoginSAG page = new LoginSAG(getDriver());
		page.openApplication();

		page.testLoginSuccess();
		Thread.sleep(1000);
		page.logout();
		Thread.sleep(1000);
		page.testLoginFailed();
		CommonFunctions.closeBrowser();

	}
}
