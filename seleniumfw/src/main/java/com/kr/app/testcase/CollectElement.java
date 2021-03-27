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

//  Login action
	@FindBy(xpath = "//input[@placeholder='Username']")
	public WebElement user;

	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement pwd;

	@FindBy(xpath = "//button")
	public WebElement lgbutton;

//  Filter school
	@FindBy(xpath = "//h2[@class='card-heading'][contains(.,'School Management')]//../button")
	public WebElement viewsch;

	@FindBy(xpath = "//input[@placeholder='Name']")
	public WebElement filschname;

	@FindBy(xpath = "//input[@placeholder='Code']")
	public WebElement filschcode;

	@FindBy(xpath = "//mat-cell[contains(.,'TEST SCHOOL 8')]")
	public WebElement schnameresult;

	@FindBy(xpath = "//mat-cell[contains(.,'200')]")
	public WebElement schcoderesult;

	@FindBy(id = "btn-search")
	public WebElement filbtn;

	@FindBy(id = "btn-clear")
	public WebElement clearbtn;

	// Add Student
	@FindBy(xpath = "//h2[@class='card-heading'][contains(.,'Student Management')]//../button")
	public WebElement viewstu;
	
	@FindBy(xpath = "//button/span[contains(.,'Add Student')]")
	public WebElement addstdbtn;
	
	@FindBy(xpath = "//input[@placeholder='Enter first name']")
	public WebElement stufirstname;
	
	@FindBy(xpath = "//input[@placeholder='Enter last name']")
	public WebElement stulastname;
	
	@FindBy(xpath = "//input[@placeholder='Enter School']")
	public WebElement stusch;
	
	@FindBy(xpath = "//span/span[contains(.,'TEST SCHOOL 11')]")
	public WebElement selsch;
	
	@FindBy(xpath = "//input[@placeholder='Enter student ID']")
	public WebElement stuID;

	@FindBy(xpath = "//mat-datepicker-toggle[@class='mat-datepicker-toggle']//button")
	public WebElement datepickerbtn;
	@FindBy(xpath = "//button[@cdkarialive='polite']")
	public WebElement viewyear;
	@FindBy(xpath = "//table//tr/td[@aria-label='2020']/div[1]")
	public WebElement selyear;
	@FindBy(xpath = "//table//tr/td[@aria-label='January 2020']/div[1]")
	public WebElement selmonth;
	@FindBy(xpath = "//table//tr/td[@aria-label='January 1, 2020']/div[1]")
	public WebElement seldate;
//	@FindBy(xpath = "//input[@placeholder='Choose a date']")
//	public WebElement datetime;
	
	@FindBy(xpath = "//div/button[@mat-raised-button][last()]")
	public WebElement addbtn;

//	Verify new student
	@FindBy(xpath = "/input[@placeholder='Student ID']")
	public WebElement searchstuID;
	
	@FindBy(id = "btn-search")
	public WebElement filstubtn;

}
