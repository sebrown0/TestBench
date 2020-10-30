package ts.iPortal.v1_0_0.login;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ts.iPortal.v1_0_0.helpers.User;
import utils.DriverGetter;
import utils.Page;

public class UserLoginTests {
	private  WebDriver driver;	
	private DriverGetter driverGetter = new DriverGetter();
	private User user;

	@Before
	public void setUp() throws Exception {
	    driver = driverGetter.getChromeDriver();
	    Page.get("http://testing.dakarhr.com/DakarHR.php",driver);		    
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void userLoginNoDetails() { 
		driver.findElement(By.cssSelector(".container-login100-form-btn:nth-child(6) > .login100-form-btn")).click();
	    List<WebElement> elements = driver.findElements(By.xpath("//div[@class= \"wrap-input100 validate-input m-b-10 alert-validate\"]"));
	    assert(elements.size() > 0);
	}
	
	@Test
	public void userLoginFail() {	
	    user = new User("XXX","XXX");
		user.login(driver);		
	    List<WebElement> elements = driver.findElements(By.xpath("//form[@id=\'loginform\']/div[5]/button"));
	    assert(elements.size() > 0);    
	}
	  
	@Test
	public void userLoginPass() {
		user = new User();
		user.login(driver);		
	    List<WebElement> elements = driver.findElements(By.xpath("//header[@class=\"app-header navbar\"]"));
	    assert(elements.size() > 0);	    		
	}

}
