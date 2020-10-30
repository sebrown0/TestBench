package ts.iPortal.v1_0_0.navigation;

import results.TestSuite;
import ts.iPortal.v1_0_0.helpers.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import results.ResultChecker;
import results.TestResult;
import utils.DriverGetter;
import utils.Page;
import utils.TestName;

public class TopLeft {
	private static WebDriver driver;
	private static DriverGetter driverGetter = new DriverGetter();
	private static User user;
	private static TestSuite testSuite; 
	private boolean passOrFail;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testSuite = new TestSuite("TopLeft");
	    driver = driverGetter.getChromeDriver();
	    Page.get("http://testing.dakarhr.com/DakarHR.php",driver);		
	    user = new User();
		user.login(driver);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		testSuite.PrintResults();
	}	
		
	@Test	
	public void moduleNameIsPresent() {
		passOrFail = ResultChecker.CheckElements(driver.findElements(By.cssSelector(".navbar-brand > div")));
		assert(passOrFail);
		testSuite.addResult(new TestResult(TestName.get(), passOrFail));
	}

//	@Test
//	public void toggleSidebarIsPresent() {
//		assert(Result.CheckElements(driver.findElements(By.cssSelector(".left-sidebar-toggler > .fa"))));		    
//	}
//
//	@Test
//	public void tclIsPresent() {
//		assert(Result.CheckElements(driver.findElements(By.cssSelector(".fa-terminal"))));    
//	}
//	
//	@Test
//	public void selectCompanyIsPresent() {		
//		assert(Result.CheckElements(driver.findElements(By.cssSelector(".nav-item > .four-boot #fourboot_"))));	    
//	}
}

//WebDriverWait wait = new WebDriverWait(driver, 30);
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".navbar-brand > div")));