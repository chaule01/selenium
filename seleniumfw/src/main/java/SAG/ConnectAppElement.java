package SAG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConnectAppElement {

	public WebDriver driver;

	public ConnectAppElement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@data-automation='password']")
	public WebElement password;

	@FindBy(xpath = "//input[@data-automation='user-name']")
	public WebElement username;

	@FindBy(xpath = "//button[@data-automation='login-submit']")
	public WebElement loginBtn;

	@FindBy(xpath = "//div[@class='alert alert-danger']")
	public WebElement warning;

	@FindBy(xpath = "//div[@class='sag_logo']")
	public WebElement logo;

	@FindBy(xpath = "//div[@class='header-settings']")
	public WebElement profile;
	
	@FindBy(xpath = "//ul[@data-automation='header-settings-body']/li[last()]")
	public WebElement logout;
	
	@FindBy(id = "span-showPassword")
	public WebElement textAnzeigen;

}
