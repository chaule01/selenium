package com.kr.app.testcase;

import static supports.CommonFunctions.visit;
import static supports.CommonFunctions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import supports.CommonFunctions;

public class LoginKR extends CollectElement {

	public LoginKR(WebDriver driver) {
		super(driver);
	}

	public void openApplication() {
		visit("https://systemmanagement-stage.karrostech.io/");

//			maximizeBrowser();
	}

	public WebElement getE(String id, String name) {
		return CommonFunctions.getElement(id, name);
	}

	public void testLoginSuccess() {
		String userName;
		String password;
		userName = "test+challenge@karrostech.com";
		password = "Test@123";
		login(userName, password);
	}


	public void login(String user, String pwd) {
		this.user.sendKeys(user);
		this.pwd.sendKeys(pwd);
		this.lgbutton.click();
	}

	public void testLoginFailed() {
		String userName;
		String password;
		userName = "challenge";
		password = "zzzzz";
		login(userName, password);

	}
}
