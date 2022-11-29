package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropdown {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.tizag.com/htmlT/htmlselect.php");
		WebElement dropdown=driver.findElement(By.name("selectionField"));
		Select select = new Select(dropdown);
		select.selectByIndex(1);
		System.out.println(select.getFirstSelectedOption().getText());
		
	}

}
