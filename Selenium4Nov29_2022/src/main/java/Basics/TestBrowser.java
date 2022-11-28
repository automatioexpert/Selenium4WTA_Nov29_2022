package Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowser {
	
public static String browser="ie";
public static WebDriver driver;

	public static void main(String[] args) {
		/*
		 * Below 3 items should be the latest one
		 * Latest selenium jar/deps
		 * Latest browser version
		 * Latest browser executable driver
		 * 
		 * Latest Selenium jars or dependencies
		 * Latest browser version
		 * Latest browser executables
		 * 
		 */
	
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();	
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();	
		}
		
		else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			 driver=new InternetExplorerDriver();	
		}
				
		driver.manage().window().maximize();
		driver.get("https://www.nasa.com");
		System.out.println(driver.getTitle());
		driver.quit();
		
	}

}
