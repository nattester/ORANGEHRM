package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/* hooks are annotations used to run a piece of code over and over again without having to write it
 Few different hooks, each with it's own functionality 
 * 1. @Before method- will run before each test method
 * 2. @Before class- will run before that class
 * 3. @Before group will run before each test group
 * 4. @Before test - will run before entire test run 
 * 5. @Before suite - it will run before each test suite 
 * All of them have an After annotation 
 */
public class HookPractice {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is before suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("This is after suite");
	}
	
	@BeforeGroups
	public void beforeGroup() {
		System.out.println("This is before group");
	}
	@AfterGroups
	public void afterGroup() {
		System.out.println("This is after group");
	}
	@BeforeTest 
	public void beforeTest() {
		System.out.println("This is before All test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("This is after All test");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is before class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("This is after class");
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is the before method");
	}
	@AfterMethod 
	public void afterMehtod() {
		System.out.println("This is the after method");
	}
	@Test(groups = {"odd", "Red"}) 
	public void test1() {
		System.out.println("This is Test 1");
	}
	
	@Test (groups = "even")
	public void test2() {
		System.out.println("This is Test 2");
	}
	
	@Test(groups = "odd") 
	public void test3() {
		System.out.println("This is Test 3");
	}
}
