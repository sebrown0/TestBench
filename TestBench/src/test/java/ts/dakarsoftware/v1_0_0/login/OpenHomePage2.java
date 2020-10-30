package ts.dakarsoftware.v1_0_0.login;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import utils.DriverGetter;
import utils.Page;

public class OpenHomePage2 {
	private WebDriver driver;
	private DriverGetter driverGetter = new DriverGetter();

	@Before
	public void setUp() throws Exception {
//	    driver = driverGetter.getChromeDriver();	    		    
	}
	
	@Test
	public void open2() {
	  assertTrue(true);
//		Page.get("https://dakarsoftware.com", driver);
	}
	
	@Test
  public void close2() {
    fail("No test case.");
  }
}
