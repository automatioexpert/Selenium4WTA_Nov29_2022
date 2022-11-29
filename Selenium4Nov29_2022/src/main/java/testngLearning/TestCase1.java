package testngLearning;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {

	@BeforeTest
	public void createDBConnection() {
		System.out.println("Create DB Connection");
	}

	@AfterTest
	public void closeDBConnection() {
		System.out.println("Close DB Connection");
	}

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Launch Browser");
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("Close Browser");
	}

	@Test(priority = 0)
	public void doUserReg() {
		System.out.println("User Registration");
	}

	@Test(priority = 1)
	public void doLogin() {
		System.out.println("Executing Login Test");

	}

}
