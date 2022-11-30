package TestGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid {

	public WebDriver driver;
	public Capabilities cap;
	//private ChromeOptions cap;

	@Parameters({"browser","url"})
	@Test
	public void browserTest(String browser,String url) throws MalformedURLException, InterruptedException {
		
		if(browser.equals("firefox")) {
			cap=new FirefoxOptions();
		}
		else if(browser.equals("chrome")) {
			
			cap=new ChromeOptions();
//			((MutableCapabilities) cap).setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
//
//			((MutableCapabilities) cap).setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
//
//			((MutableCapabilities) cap).setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); 
//			// options = new ChromeOptions();
			
			/*
			 * cap.addArguments("--window-position=0,0");
			 * options.addArguments("--window-size=1840,1080");
			 * options.addArguments("--no-sandbox"); options.addArguments("--disable-gpu");
			 * options.addArguments("--headless");
			 */
		}
		driver= new RemoteWebDriver(new URL("http://localhost:4444/"),cap);
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.name("q")).sendKeys("Java 8 on browser: "+browser);
		Thread.sleep(5000);
		driver.quit();
	}
}
