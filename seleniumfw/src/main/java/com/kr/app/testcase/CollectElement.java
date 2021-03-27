package com.kr.app.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CollectElement {

	public WebDriver driver;

	public CollectElement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	public WebElement user;

	@FindBy(xpath = "//button")
	public WebElement lgbutton;

	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement pwd;

}
