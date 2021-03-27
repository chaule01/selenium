package SAG;

import supports.CommonFunctions;

public class LoginRun {

	public static void main(String[] args) throws InterruptedException {

		CommonFunctions.setBrowser("chrome");

		LoginSAG page = new LoginSAG(CommonFunctions.getDriver());
		page.openApplication();

		page.testLoginSuccess();
		Thread.sleep(1000);
		page.logout();
		Thread.sleep(1000);
		page.testLoginFailed();
		CommonFunctions.closeBrowser();

	}

}
