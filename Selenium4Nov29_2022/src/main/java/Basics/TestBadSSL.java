package Basics;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v104.emulation.Emulation;
import org.openqa.selenium.devtools.v106.security.Security;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBadSSL {
	public static void main(String[] args) {
		//Latitude and longitude coordinates are: 51.509865, -0.118092.
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		DevTools devTools=((HasDevTools) driver).getDevTools();
		devTools.createSession();
		//devTools.send(Security.enable());
		//devTools.send(Security.setIgnoreCertificateErrors(true));
		
		devTools.send(Emulation.setGeolocationOverride(Optional.of(51.509865), Optional.of(-0.118092), Optional.of(100)));
		
		driver.get("https://mycurrentlocation.net/");
		driver.manage().window().maximize();
		
	}

}
