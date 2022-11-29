package Basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRelativeLocators {

	/*
	 * above,below, right of, left of, near - Relative Locators
	 * 
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.way2automation.com/way2auto_jquery/index.php");

		WebElement above = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.tagName("select")));
		above.sendKeys("trainer@way2automation.com");
		
		//Enter value in City text box
		WebElement city=driver.findElement(RelativeLocator.with(By.xpath("//input[@name='city']")).below(By.name("country")));
		city.sendKeys("New Delhi");
		
		System.out.println("Entered city name");
		
		//Enter Name
		driver.findElement(RelativeLocator.with(By.name("name")).above(By.xpath("//input[@name='phone']"))).sendKeys("trainer3493777777777493473743384834");
		
		//Enter phone
		
		driver.findElement(RelativeLocator.with(By.xpath("//input[@name='phone']")).below(By.name("name"))).sendKeys("83488348348");
		
		//Enter username
		driver.findElement(RelativeLocator.with(By.name("username")).below(By.name("city"))).sendKeys("User384343949494348");
		
		//Enter password
		//driver.findElement(RelativeLocator.with(By.name("password")).below(By.name("username"))).sendKeys("P930403483403488");
		
		driver.findElement(RelativeLocator.with(By.xpath("(//input[@name='password'])[2]")).toRightOf(By.tagName("label"))).sendKeys("P9304034834034883448348");
		
		//Near Sign in link
		
		driver.findElement(RelativeLocator.with(By.xpath("(//a[contains(text(),'THE TESTING WEBSITE')])[2]")).near(By.linkText("Signin"))).click();
		Thread.sleep(4000);
		System.out.println("Test Passed");

	}
}
