package utils;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice {

	// There are 2 types of assert hard and soft assert; assert helps us to determine the result of the test
	// Hard Assert: if we have multiple asserts,if the first assert fails, it fails the entire test. It does not continue
	// Soft Assert: continues throughout the test run before failing the test 
	@Test
	public void hardAssert() { //static
		Assert.assertEquals(2, 2);

		Assert.assertEquals("natalia", "natalia");

		Assert.assertEquals(12, 12);
	}
	
	@Test
	public void softAssert() {// have to create an object; not static 
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(2, 1);
		sa.assertEquals("natalia", "natalia");
		sa.assertEquals(34, "nat");
		
		// anytime we are using soft assert we have to end with assert all
		sa.assertAll();
	}
}
