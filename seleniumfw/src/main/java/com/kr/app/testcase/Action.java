package com.kr.app.testcase;

import static supports.CommonFunctions.visit;
import static supports.CommonFunctions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import supports.CommonFunctions;

public class Action extends CollectElement {

	public Action(WebDriver driver) {
		super(driver);
	}

	public void openApplication() {
		visit("https://systemmanagement-stage.karrostech.io/");

//			maximizeBrowser();
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
	
//  Filter school
	public void FilterSchoolbyName() {
		String name = "TEST SCHOOL 8";
		this.viewsch.click();
		this.filschname.sendKeys(name);
		this.filbtn.click();
	}

	public void FilterSchoolbyCode() {
		this.viewsch.click();
		String code = "200";
		this.filschcode.sendKeys(code);
		this.filbtn.click();
	}

	public void clearfilter() {
		this.clearbtn.click();
	}
	
//	Add new student
	public void AddStudentSuccess () {
		String firstname = "Test";
		String lastname = "Student 01";
		String stuID = "STD002";
		AddStudent(firstname,lastname,stuID);
		
	}
	
	public void AddStudent(String fn, String ln,String sID ) {
		this.viewstu.click();
		this.addstdbtn.click();
//		String datetime = "4/11/2021";
//		this.datetime.sendKeys(datetime);
		this.stusch.click();
		this.selsch.click();
		this.datepickerbtn.click();
		this.viewyear.click();
		this.selyear.click();
		this.selmonth.click();
		this.seldate.click();
		this.stufirstname.sendKeys(fn);
		this.stulastname.sendKeys(ln);
		this.stuID.sendKeys(sID);
		this.addbtn.click();
	}
	public void VerifyStudent(String stuID) {
		this.searchstuID.sendKeys(stuID);
		this.filstubtn.click();
	}

}
