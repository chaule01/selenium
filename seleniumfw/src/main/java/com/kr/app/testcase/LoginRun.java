package com.kr.app.testcase;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import supports.CommonFunctions;

public class LoginRun {

	@Test
	public void testLoginSucess() throws InterruptedException {
		CommonFunctions.setBrowser("chrome");
		Action page = new Action(CommonFunctions.getDriver());
		page.openApplication();
		page.testLoginSuccess();
		Thread.sleep(1000);
		CommonFunctions.closeBrowser();

	}

	@Test
	public void testFilterSchoolbyName() throws InterruptedException {
		CommonFunctions.setBrowser("chrome");
		Action page = new Action(CommonFunctions.getDriver());
		page.openApplication();
		page.testLoginSuccess();
		Thread.sleep(1000);
		page.FilterSchoolbyName();
		Thread.sleep(1000);
		CommonFunctions.waitForElementPresence("xpath", "//mat-cell[contains(.,'TEST SCHOOL 8')]");
		CommonFunctions.closeBrowser();
	}
	
	@Test
	public void testFilterSchoolbyCode() throws InterruptedException {
		CommonFunctions.setBrowser("chrome");
		Action page = new Action(CommonFunctions.getDriver());
		page.openApplication();
		page.testLoginSuccess();
		Thread.sleep(1000);
		page.FilterSchoolbyCode();
		Thread.sleep(1000);
		CommonFunctions.waitForElementPresence("xpath", "//mat-cell[contains(.,'200')]");
		CommonFunctions.closeBrowser();
	}
	
	@Test
	public void testAddStudent() throws InterruptedException {
		CommonFunctions.setBrowser("chrome");
		Action page = new Action(CommonFunctions.getDriver());
		page.openApplication();
		page.testLoginSuccess();
		page.AddStudentSuccess();
//		CommonFunctions.waitForElementPresence("xpath", "//mat-cell[contains(.,'STD002')]");
		CommonFunctions.closeBrowser();
	}
}
