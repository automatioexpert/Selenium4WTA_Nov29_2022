package testngLearning;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class customListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("onTestStart triggered");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess triggered");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.out.println("onTestFailure triggered");
		Reporter.log("<a href=\"C:\\Users\\valmiki\\Desktop\\Books.png\" target=\"_blank\">Screenshot</a>");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped triggered");
		Reporter.log("<a href=\"C:\\Users\\valmiki\\Desktop\\Books.png\" target=\"_blank\">Screenshot</a>");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage triggered");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout triggered");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart triggered");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish triggered");
	}
	

}
