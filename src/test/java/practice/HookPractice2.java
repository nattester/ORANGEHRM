package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HookPractice2 extends HookPractice {
	
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
	
	@Test (groups = "even")
	public void test7() {
		System.out.println("This is Test 7");
	}
	
	@Test (groups = "odd")
	public void test8() {
		System.out.println("This is Test 8");
	}
	
	@Test (groups = "even")
	public void test9() {
		System.out.println("This is Test 9");
	}
}
