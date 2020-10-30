package ts.iPortal.v1_0_0.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class User {
	private String userName;
	private String password;
//	private static WebDriver driver;
	
	public User() {
		super();
		this.userName = "steve";
		this.password = "123";
	}
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public void login(WebDriver driver) {
	  driver.findElement(By.name("user")).sendKeys(userName);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.cssSelector(".container-login100-form-btn:nth-child(6) > .login100-form-btn")).click();		
	}	
}
