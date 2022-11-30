package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentReports createInstance(String fileName) {
		
		//ExtentSparkReporter  htmlReporter;// Create HTML file
		 ExtentReports extent; // Add config, system, test cases
		 ExtentTest test;// maintain test cases, add logs-pass, fail,skip etc

		ExtentSparkReporter	htmlReporter = new ExtentSparkReporter(fileName	);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Arda Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Test Engineer", "VV Automation Expert");
		extent.setSystemInfo("Build No", "19.9.22");
		extent.setSystemInfo("Organization", "ABC");

		
		return extent;
		
	}

}
