package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class SeleniumHelper {
	// Create functions that you can use again and again 

	WebDriver driver = DriverManager.getDriver();
	WebDriverWait wait;

	// will return the title of the page 
	public String GetTitle() {
		return driver.getTitle();

	}
	// will go to the given web site 
	public void GoToURL(String url) {
		driver.get(url);
	}
	//Navigate to the given web site 
	public void NavigateToUrl(String url) {
		driver.navigate().to(url);

	}
	// go to previous page 
	public void navigateBack() {
		driver.navigate().back();
	}
	//Navigate forward
	public void navigateForward() {
		driver.navigate().forward();	
	}

	// Refresh page
	public void refreshpage() {
		driver.navigate().refresh();
	}
	//hard sleep with given amount in seconds
	public void sleep (int sec )  {

		try {
			Thread.sleep(1000*sec);
		} catch (InterruptedException e) {
			System.out.println("System broke while sleeping");
			e.printStackTrace();


		}
	}
	//Will find and return element 
	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
			
	}
	
	//Explicit wait- will search for element until given condition is met 
	public WebElement waitForElement(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		WebElement webElement  =  wait.until(ExpectedConditions.visibilityOf(element));
		highlightElement(element);
		unhighlightElement(element);
		return webElement;
		
	}

//Fluent Wait - will search for an element after every interval of time until the condition is met
	public WebElement waitForElementFluent(WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		
		return wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	//Will check if web element exists and return true or false 
	public boolean ifWebElementExists (WebElement element) {
		boolean isPresent;
		try {
			wait = new WebDriverWait(driver, 20);
			isPresent = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
			
			return isPresent;
		}catch(Exception e) {
			return false;	
		}
	}
	
	//highlight element
	public void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border = '3px solid red'", element);
		sleep(1);
	}
	
	//will un-highlight
	public void unhighlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border = '0px solid red'", element);
		sleep(1);
	}
	
	//select from the drop down by index
	public void selectFromDropDown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
		
	}
	
	//select by value from drop down 
	public void selectFromDropDown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);	
	}

	//accept alert
	public void acceptAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	
	//To dismiss alert
	public void dismissAlert() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}
	
	//switch to iframe using index
	public void switchToIFRame(int index) {
		driver.switchTo().frame(index);
	}
	
	//switch to iframe using value
	public void switchToIFRame(String value) {
		driver.switchTo().frame(value);
	}
	
	//switch to parent frame
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	
	// get window handle 
	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();	
	}
	
	//switch to new window
	public String switchWindow() {
		String parentWindow = getCurrentWindowHandle();
		Set<String>allWindows = driver.getWindowHandles();
		for(String windows: allWindows){
		driver.switchTo().window(windows);	
		}
		String childWindow = getCurrentWindowHandle();
		return childWindow;
	}
	
	//Switch to next window
	public String switchToNextWindow() {
		String parent = getCurrentWindowHandle();
		Set<String>allWindows = driver.getWindowHandles();
		for(String window: allWindows){
			driver.switchTo().window(window);
			if(!window.equals(parent)) {
				
				driver.switchTo().window(window);
			}
			}
			String childWindow = getCurrentWindowHandle();
			return childWindow;
	}
	
	//open new tab/window
	public void openNewWindow(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
	}
	
	//Open URL in a new window 
	public void openUrlInNewWindow(String url){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('" + url + "')");
		//"window.open('www.google.com')"
		
}
	
	//Date Function
	public String date() {
		DateFormat df = new SimpleDateFormat("MM-dd-yy HH.mm.ss");
		Date date = new Date();
		String finaldate = df.format(date); 
		return finaldate;
	}
	//Take screenshot
	public void takeScreenShot() {
		String name = "Screen shot" + date()  + ".png";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			File localScreenshot = new File(new File("build"),"screenshots");
			
			if(!localScreenshot.exists() || !localScreenshot.isDirectory()) {
				localScreenshot.mkdirs();
				
		}
			File screenshot = new File(localScreenshot, name);
			Files.copy(sourceFile, screenshot);
		
	
	}catch(IOException e) {
		System.out.println("screenshot capture failed");
	}
}
	
	//To read excel sheet
	public String getDataFromExcelSheet(String filePath, String sheetName, int rownum, int cellnum) {
		String data = null;
		try {
			File file = new File(filePath);
			FileInputStream fs = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sheet = wb.getSheet(sheetName);
			data = sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
			
		}
		catch(IOException e){
			System.err.println("unable to read file");
		}
		
		return data;
	}
	//Action to handle keyboard and mouse action
	public Actions action() {
		Actions actions= new Actions(driver);
		return actions;
	}
}






