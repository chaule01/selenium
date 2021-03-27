package com.kr.app.testcase;

import org.junit.Assert;
import org.junit.Test;

import supports.CommonFunctions;

public class LoginRun {

	@Test
	public void testLoginSucess() throws InterruptedException {
		CommonFunctions.setBrowser("chrome");

		LoginKR page = new LoginKR(CommonFunctions.getDriver());
		page.openApplication();
		page.testLoginSuccess();
		Thread.sleep(5000);
		CommonFunctions.closeBrowser();

	}

	@Test
	public void testAhihi() throws InterruptedException {
		Assert.assertEquals(1, 2);
	}

}
