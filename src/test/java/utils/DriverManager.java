package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
// Getter for the driver opens up more options to use driver
//unconditional- Thread.sleep
//conditional- implicit wait, explicit wait, and fluent wait for synchronization
//Implicit Wait- only used once throughout the entire run. It is the wait for the DOM. Some amount of time will be assigned 
//				- it is only used for find element
//Explicit Wait- It has more conditions not just time, it will only wait for a specific element. element by element 
//				-most used 
//Fluent Wait- similar to explicit wait but it has polling time(intervals) 
//			 - ex. checking every 5 seconds for duration of entire wait time 
//			 -Ignores exception until wait time is done 


public class DriverManager {
	private static WebDriver driver = null;

	public static WebDriver getDriver() {
		return driver;
	}

	public WebDriver openBrowser(String browser){
		if(browser.equalsIgnoreCase("Chrome")) {
			//System.setProperty("webdriver.chrome.driver", "");
			driver = new ChromeDriver();


		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			//System.setProperty("webdriver.chrome.driver", "/Users/nataliahernandez/Documents/Drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("Edge")) {
			//System.setProperty("webdriver.chrome.driver", "/Users/nataliahernandez/Documents/Drivers/edgedriver");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Incorrect Driver, please input correct driver");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
		
	public void QuitBrowser () {
		driver.quit();
		
	}
	
	public void CloseBrowser() {
		driver.close();
	}
}
