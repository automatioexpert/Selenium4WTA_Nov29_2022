package Basics;

import java.time.Duration;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAuthentication {

	/*
	 * above,below, right of, left of, near - Relative Locators
	 * 
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		((HasAuthentication) driver).register(UsernameAndPassword.of("admin", "admin"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		System.out.println("Test is Passed");
		driver.quit();
		
	}
}
