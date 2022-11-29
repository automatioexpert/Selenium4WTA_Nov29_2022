package testngLearning;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {

	@Test
	public void validateTitle() {
		String expectedTitle = "Gmail.com";
		String actualTitle = "Google.com";

		/*
		 * if(expectedTitle.equals(actualTitle)) { System.out.println("Test passed");
		 * Assert.assertTrue(true); } else { System.out.println("Test Failed");
		 * Assert.assertTrue(false); }
		 */

		SoftAssert soft = new SoftAssert();

		soft.assertEquals(actualTitle, expectedTitle);
		soft.assertTrue(false, "Button is not present");
		soft.fail("Condition not met hence failing the test");
		System.out.println("Ending the test");
		soft.assertAll();
	}
}
