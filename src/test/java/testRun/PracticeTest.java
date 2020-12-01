package testRun;


	
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageFactory.DashboardPageFactory;
import pageFactory.HomePageFactory;
import utils.DriverManager;
import utils.SeleniumHelper;

//When a class object gets created all the variables are initialized 

public class PracticeTest {

	@Test
	public void firstTest() {
		
		DriverManager dm = new DriverManager();
		dm.openBrowser("Chrome");
		SeleniumHelper sh = new SeleniumHelper();
		HomePageFactory hpf = new HomePageFactory(DriverManager.getDriver());
		DashboardPageFactory dashboard = new DashboardPageFactory(DriverManager.getDriver());
		/*hpf.usernameTextBox.sendKeys("Admin");
		hpf.passwordTextBox.sendKeys("admin123");
		hpf.logIn.click();*/
		
		
		
		sh.GoToURL("https://opensource-demo.orangehrmlive.com");
		String window1 = sh.getCurrentWindowHandle();
		System.out.println(window1);
		hpf.enterUsername("Admin");
		hpf.enterPassword("admin123");
		hpf.clickLogIn();
		sh.action().contextClick().perform();
		/*sh.openUrlInNewWindow("https://opensource-demo.orangehrmlive.com");
		sh.sleep(1);
		sh.GoToURL("https://www.google.com/");
		//sh.switchWindow();
		sh.switchToNextWindow();
		sh.GoToURL("https://www.google.com/");
		String window2 = sh.getCurrentWindowHandle();
		System.out.println(window2);
		*/
		//sh.takeScreenShot();
		sh.sleep(2);
		dm.QuitBrowser();
		
	
		
		
		/*dashboard.clickPim();
		dashboard.selectEmployeeStatus(4);
		sh.sleep(2);
		/*String actual = dashboard.getTextDashboardTitle();
		String expected = "Dashboard";
		Assert.assertEquals(actual, expected);
		/*WebElement header = sh.getElement("//div[@id='logInPanelHeading']");
		String title = header.getText();
		System.out.println(title);
		String title2 = sh.waitForElement(header).getText();
		String title3 = sh.waitForElement(header).getText();
		//System.out.println(header);
		System.out.println(title2);
		System.out.println(title3);
		System.out.println(sh.ifWebElementExists(header));
		/*sh.NavigateToUrl("https://www.google.com");
		sh.navigateBack();
		sh.navigateForward();
		sh.refreshpage();
		System.out.println(sh.GetTitle()); 
		 */
		
	}
	@Test 
	public void test2() {
		SeleniumHelper sh = new SeleniumHelper();
		System.out.println(sh.date());
	}

}
