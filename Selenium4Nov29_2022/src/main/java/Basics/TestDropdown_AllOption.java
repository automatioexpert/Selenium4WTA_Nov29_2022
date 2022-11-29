package Basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropdown_AllOption {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.wikipedia.org/");
		//WebElement language = driver.findElement(By.id("searchLanguage"));
		List<WebElement> options = driver.findElements(By.cssSelector("select#searchLanguage>option"));
		System.out.println("Total values in dropdown are: "+options.size());
		
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
		
		driver.quit();

	}

}
