package Basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMouseOver {

	public static void main(String[] args) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.tizag.com/htmlT/htmlselect.php");

		
		Actions act = new Actions(driver);

		for (int i = 1; i <= 10; i++) {
			WebElement tutorial = driver.findElement(By.xpath("//a[contains(text(),'Beginner Tutorial')]"));
			act.moveToElement(tutorial).build().perform();
			driver.findElement(By.cssSelector("img[alt='Tizag Tutorials']")).click();
			Thread.sleep(3000);
		}

		
	}

}
