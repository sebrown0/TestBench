package unit_tests.test_runner;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import app.TestAppDataGetter;
import reports.TestSuiteResults;
import testRunner.ModuleRunner;
import unit_tests.app.TestAppDataHelper;

public class ModuleRunnerTest {
  private static final TestAppDataGetter TEST_DATA_HELPER = TestAppDataHelper.getTestappdata();
  private static ModuleRunner testRunner = new ModuleRunner(TEST_DATA_HELPER);
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }
  
	@Test
	public void runTestSuite() {		
		testRunner.runTestModules();
	}
  
  @Test
  public void runTestSuite_andGetResults() {    
    testRunner.runTestModules();
    TestSuiteResults results = testRunner.getResults();
//    assertEquals("OpenHomePage", results.getResults().get(0).getName());
  }
}
