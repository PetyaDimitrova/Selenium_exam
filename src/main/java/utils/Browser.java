package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	public static WebDriver driver;
	
	public static void browserInit(){
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_drivers\\chromedriver.exe");
		driver = new  ChromeDriver();
		
	}

	public static void shutDown() {
		driver.quit();
		
	}
}
