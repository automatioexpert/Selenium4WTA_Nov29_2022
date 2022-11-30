package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;

import extentlisteners.ExtentListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.DbManager;
import utilities.MonitoringMail;

public class BaseTest {

	/*
	 * WebDriver TestNG Extent Reports JDBC Mail Screenshots Keywords ExcelReading
	 * Log4j Properties implicit and explicit waits
	 * 
	 */

	public static WebDriver driver;
	private static Properties OR = new Properties();
	private static Properties config = new Properties();
	private static FileInputStream fis;
	private Logger log = Logger.getLogger(BaseTest.class);
	public static WebDriverWait wait;
	//public static ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
	public static MonitoringMail mail = new MonitoringMail();

	public void click(String locatorKey) {
		try {
			if (locatorKey.endsWith("_XPATH")) {

				driver.findElement(By.xpath(OR.getProperty(locatorKey))).click();
			} else if (locatorKey.endsWith("_CSS")) {

				driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).click();
			} else if (locatorKey.endsWith("_ID")) {

				driver.findElement(By.id(OR.getProperty(locatorKey))).click();
			}

			log.info("Clicking on an Element : " + locatorKey);
			ExtentListeners.test.log(Status.INFO, "Clicking on an Element : " + locatorKey);
			
		} catch (Throwable t) {
			log.info("Error while Clicking on an Element : " + locatorKey);
			ExtentListeners.test.log(Status.FAIL, "Error while Clicking on an Element : " + locatorKey);
			
			Assert.fail(t.getMessage());

		}
	}

	public void type(String locatorKey, String value) {
		try {
			if (locatorKey.endsWith("_XPATH")) {

				driver.findElement(By.xpath(OR.getProperty(locatorKey))).sendKeys(value);
			} else if (locatorKey.endsWith("_CSS")) {

				driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).sendKeys(value);
			} else if (locatorKey.endsWith("_ID")) {

				driver.findElement(By.id(OR.getProperty(locatorKey))).sendKeys(value);
			}
			ExtentListeners.test.log(Status.INFO, "Typing in an Element : " + locatorKey + " entered the value as : " + value);
			log.info("Typing in an Element : " + locatorKey + " entered the value as : " + value);
		} catch (Throwable t) {

			log.info("Error while typing in an Element : " + locatorKey );
			ExtentListeners.test.log(Status.FAIL, "Error while typing in an Element : " + locatorKey);
			
			Assert.fail(t.getMessage());

		}

	}

	@BeforeSuite
	public void setUp() {

		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");

		log.info("Test Execution Started !!!");

		try {
			fis = new FileInputStream("./src/test/resources/properties/Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			config.load(fis);
			log.info("Config properties file loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			OR.load(fis);
			log.info("OR properties file loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (config.getProperty("browser").equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome browser launched !!!");

		} else if (config.getProperty("browser").equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox browser launched !!!");

		}

		driver.get(config.getProperty("testsiteurl"));
		log.info("Navigated to : " + config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));

		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));

		try {
			DbManager.setMysqlDbConnection();
			log.info("DB Connection Established !!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void tearDown() {

		driver.quit();
		log.info("Test Execution Completed !!!");

	}

}
