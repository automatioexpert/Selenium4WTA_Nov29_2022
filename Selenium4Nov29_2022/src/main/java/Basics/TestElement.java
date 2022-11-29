package Basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestElement {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("trainer@way2automation.com");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
		By pwd=By.name("Passwd");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pwd)).sendKeys("Password");
		
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		By wrong=By.xpath("//span[contains(text(),'Wrong password')]");
		
		String txt=wait.until(ExpectedConditions.presenceOfElementLocated(wrong)).getText();
		System.out.println(txt);
		driver.quit();
	}

}
