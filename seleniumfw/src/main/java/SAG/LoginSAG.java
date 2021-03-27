package SAG;

import static supports.CommonFunctions.visit;
import static supports.CommonFunctions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import supports.CommonFunctions;

public class LoginSAG extends ConnectAppElement {

	public LoginSAG(WebDriver driver) {
		super(driver);
	}

	public void openApplication() {
		visit("https://ch.bbv-demo.ch/wbb");

//			maximizeBrowser();
	}

	public WebElement getE(String id, String name) {
		return CommonFunctions.getElement(id, name);
	}

	public void testLoginSuccess() {
		String userName;
		String password;
		userName = "5101444";
		password = "123456@A";
		login(userName, password);
//		waitForElementInvisible("xpath", "//div[@class='card-header']");
	}
	

	public void login(String userName, String password) {
		this.password.sendKeys(password);
		this.username.sendKeys(userName);
		this.loginBtn.click();
	}
	
	public void logout() { 
		this.profile.click();
		this.profile.getText();
		System.out.println(this.logout.getText());
		this.logout.click();
	}

	public void testLoginFailed() {
		String userName;
		String password;
		userName = "5101444";
		password = "zzzzz";
		login(userName, password);
		System.out.println(this.warning.getText());
		waitForElementPresence("xpath", "//div[@class='alert alert-danger']");
	}
}
