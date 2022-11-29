package testngLearning;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3 {

	@Test(priority = 1)
	public void doRegistration() {
		System.out.println("Executing doRegistration test");

		Reporter.log("Inside UserRegistration test");
		//Assert.fail("Failing the test as the login button is missing");

	}

	@Test(priority = 2, dependsOnMethods = "doRegistration")
	public void doLogin() {

		Reporter.log("Inside doLogin test");
		System.out.println("Executing doLogin Test");

		
	}

	@Test(priority = 3)
	public void isSkip() {

		Reporter.log("Inside isSkip test");
		throw new SkipException("Skipping the test as the data is not set");

	}

}
