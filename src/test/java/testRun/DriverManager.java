package testRun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	private WebDriver driver = null;

	public  WebDriver openBrowser(String browser) {

		if(browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			System.out.println("The chrome browser has been opened");

		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			System.out.println("The firefox browser has been opened");

		}
		else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
			System.out.println("The edge browser has been opened");

		}
		else {
			System.out.println("This driver is not supported please try a valid driver");
		}
		driver.manage().window().fullscreen();
		return driver;
	}
	public void closeWindow(){

		driver.close();

	}

	public void quitBrowser() {
		driver.quit();

	}
}

