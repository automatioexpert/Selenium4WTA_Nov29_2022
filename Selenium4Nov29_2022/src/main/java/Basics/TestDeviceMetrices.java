package Basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v104.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDeviceMetrices {
	public static void main(String[] args) {
		//Latitude and longitude coordinates are: 51.509865, -0.118092.
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		//driver.manage().window().maximize();
		
		//DevTools devTools=((HasDevTools) driver).getDevTools();
		//devTools.createSession();
		//devTools.send(Security.enable());
		//devTools.send(Security.setIgnoreCertificateErrors(true));
		
		//devTools.send(Emulation.setDeviceMetricsOverride(600, 600, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
		Map<String,Object> deviceMetrices= new HashMap<String,Object>(){{
			put("width",600);
			put("height",1000);
			put("mobile",true);
			put("deviceScaleFactor",50);
			
			
			
		}
		};
		
		((ChromiumDriver) driver).executeCdpCommand("Emulation.setDeviceMetricsOverride",deviceMetrices);
		
	
		driver.get("https://mycurrentlocation.net/");
		
		
	}

}
