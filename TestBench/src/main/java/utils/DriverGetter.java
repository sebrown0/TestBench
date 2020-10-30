package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGetter {
	private WebDriver driver;
	
	
	public DriverGetter() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SteveBrown\\Selenium\\chromedriver.exe");
	}

	public WebDriver getChromeDriver() {		
	    driver = new ChromeDriver();
		return this.driver;		
	}

}
