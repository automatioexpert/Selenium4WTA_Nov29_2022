package Basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties {
	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static Logger log=	Logger.getLogger(TestProperties.class);
	
	
	public static void click(String locator) {
		
	if(locator.endsWith("_xpath")) {
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
		log.info("Clicking on WebElement: "+locator);
		
	}
	else if(locator.endsWith("_css")) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		log.info("Clicking on WebElement: "+locator);
		
	}
	
	else if(locator.endsWith("_id")) {
		driver.findElement(By.id(OR.getProperty(locator))).click();
		log.info("Clicking on WebElement: "+locator);
		
	}
	else if(locator.endsWith("_name")) {
		driver.findElement(By.name(OR.getProperty(locator))).click();
		log.info("Clicking on WebElement: "+locator);
		
	}
	
	else if(locator.endsWith("_linkText")) {
		driver.findElement(By.linkText(OR.getProperty(locator))).click();
		log.info("Clicking on WebElement: "+locator);
		
	}
	
	else if(locator.endsWith("_className")) {
		driver.findElement(By.className(OR.getProperty(locator))).click();
		log.info("Clicking on WebElement: "+locator);
		
	}
	
	

		
	}
	
public static void type(String locator,String value) {
	driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);;
	log.info("Entered text on WebElement: "+locator+" with value: "+value);
		
	}

public static void quit() {
	
	driver.quit();
	log.info("Closed all the browser instance");
	
}

	public static void main(String[] args) throws IOException, InterruptedException {
		
	PropertyConfigurator.configure("./src/main/resources/log4j.properties");
	log.info("Log started logging");

		fis = new FileInputStream(new File("./src/main/resources/Config.properties"));
		config.load(fis);
		log.info("Config file loaded");
		
		fis = new FileInputStream(new File("./src/main/resources/OR.properties"));
		OR.load(fis);

		log.info("OR file loaded");
		
		System.out.println(config.getProperty("url"));
		System.out.println(config.getProperty("browser"));
		System.out.println(OR.getProperty("usernmaeTxtBox"));
		System.out.println("=========================================");

		if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome browser is launched");
		}

		else if (config.getProperty("browser").equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(config.getProperty("url"));
		log.info("URL is launched: "+config.getProperty("url"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));	
	
		//driver.findElement(By.id(OR.getProperty("usernmaeTxtBox"))).sendKeys("trainer@way2automation.com");
	type("usernmaeTxtBox", "trainer@way2automation.com");
	
	//driver.findElement(By.xpath(OR.getProperty("nextBtn"))).click();
	click("nextBtn");

	//driver.findElement(By.cssSelector(OR.getProperty("passwordTextBox"))).sendKeys("34833488888888888888888888888");
	type("passwordTextBox", "3594575747597467467");
	
	//driver.findElement(By.xpath(OR.getProperty("nextBtn"))).click();
	click("nextBtn");
	
	
	System.out.println(driver.findElement(By.xpath(OR.getProperty("errorMessage"))).getText());
	System.out.println("Test case got passed");
	
	log.info("Gmail Login Test Passed");
	Thread.sleep(5000);
	quit();
	}

}
