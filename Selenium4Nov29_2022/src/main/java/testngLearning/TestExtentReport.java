package testngLearning;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestExtentReport {

	public ExtentSparkReporter htmlReporter;// Create HTML file
	public ExtentReports extent; // Add config, system, test cases
	public ExtentTest test;// maintain test cases, add logs-pass, fail,skip etc

	@BeforeTest
	public void setUpReport() {
		htmlReporter = new ExtentSparkReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Arda Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Test Engineer", "VV Automation Expert");
		extent.setSystemInfo("Build No", "19.9.22");
		extent.setSystemInfo("Organization", "ABC");
		

	}
	
	@Test
	public void doLogin() {
		test=extent.createTest("doLogin Test");
		test.info("Entered username");
		test.info("Entered password");
		test.info("Clicked on sign button");
		test.info("Verify page title");
		test.pass("Login Test passed");
		Assert.assertTrue(true);
		
	}
	
	@Test
	public void doRegistration() {
		test=extent.createTest("doRegistration Test");
		test.info("Entered username");
		test.info("Entered password");
		test.info("Clicked on sign button");
		test.info("Verify page title");
		test.fail("doRegistration Test passed");
		Assert.fail();
		
		
	}
	@AfterTest
	public void endReport() {
		
		extent.flush();
	}

}
