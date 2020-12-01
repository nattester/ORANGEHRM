package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;
import utils.SeleniumHelper;

public class HomePageFactory {
	//Page Object Model-  to organize everything based on pages

SeleniumHelper sh = new SeleniumHelper();

	public HomePageFactory(WebDriver driver) {
		driver = DriverManager.getDriver();// we are assigning the driver
		PageFactory.initElements(driver, this);//looking the driver and its location,
	}


	@FindBy(xpath = "//div[@id='logInPanelHeading']")
	public WebElement logInPanelTitle;

	@FindBy(xpath = "//input[@id='txtUsername']")
	public WebElement usernameTextBox;

	@FindBy(xpath = "//input[@id='txtPassword']")
	public WebElement passwordTextBox;

	@FindBy(xpath = "//input[@id='btnLogin']")
	public WebElement logIn;

	public void enterUsername(String username) {
		sh.waitForElement(usernameTextBox).sendKeys(username);
		
	}
	public void enterPassword(String password) {
		//passwordTextBox.sendKeys(password);
		sh.waitForElement(passwordTextBox).sendKeys(password);
	}
	public void clickLogIn() {
		sh.waitForElement(logIn).click();
		//logIn.click();
	}
}
