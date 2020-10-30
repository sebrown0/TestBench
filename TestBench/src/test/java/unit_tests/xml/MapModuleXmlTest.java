package unit_tests.xml;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

import app.AppDataGetter;
import app.AppModulePathGetter;
import app.IncludedModulesGetter;
import app.TestAppDataGetter;
import app.TestModuleGetter;
import unit_tests.app.TestAppDataHelper;
import xml.test_module.AppPaths;
import xml.test_module.TestCase;
import xml.test_module.TestModule;
import xml.test_module.TestSuite;
import xml.test_module.TestSuiteClass;
import xml.test_module.TestSuiteGetter;
import xml.test_module.TestSuiteList;

public class MapModuleXmlTest {  
  private static final TestAppDataGetter TEST_DATA_HELPER = TestAppDataHelper.getTestappdata();
  private AppDataGetter appDataGetter = TEST_DATA_HELPER.getAppDataGetter();  
  private TestModuleGetter testModuleGetter = TEST_DATA_HELPER.getModuleGetter();
  private AppModulePathGetter appModulePathGetter = TEST_DATA_HELPER.getAppModulePathGetter();
  private IncludedModulesGetter includedModulesGetter = new IncludedModulesGetter(testModuleGetter, appModulePathGetter);;
  private List<TestModule> includedModules = includedModulesGetter.getIncluded();;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

  }

  @Test
  public void appName() {
    assertEquals("dakarsoftware", appDataGetter.getAppName());
  }
  
  @Test
  public void appVersion() {    
    assertEquals("v1_0_0", appDataGetter.getAppVersion());
  }
  
  @Test
  public void appPath_URL() {
    AppPaths ap = testModuleGetter.getAppPaths();    
    assertEquals("ts.dakarsoftware.v1_0_0.", ap.getTestModuleURL());
  }
  
  @Test
  public void appPath_Path() {
    AppPaths ap = testModuleGetter.getAppPaths();    
    assertEquals("src/test/java/ts/", ap.getTestModulePath());
  }
  
  @Test
  public void moduleName() {
    TestModule tm = includedModules.get(0);
    assertEquals("login", tm.getModuleName());
  }
    
  @Test
  public void getTestSuiteList() throws ClassNotFoundException {    
    TestModule tm = includedModules.get(0);
    TestSuiteGetter<List<TestSuite>> tsGetter = new TestSuiteList();
    List<TestSuite> testSuiteList = (tm.getTestSuites(tsGetter, testModuleGetter.getModuleData()));
    assertEquals("OpenHomePage", testSuiteList.get(0).getName());
  }
  
  @Test
  public void getTestSuiteClasses() throws ClassNotFoundException {    
    TestModule tm = includedModules.get(0);
    TestSuiteGetter<Class<?>[]> tsGetter = new TestSuiteClass();
    Class<?>[] testSuiteClasses = ( tm.getTestSuites(tsGetter, testModuleGetter.getModuleData()));
    assertEquals("OpenHomePage", testSuiteClasses[0].getSimpleName());
  }
  
  @Test
  public void testCase_Num_2() throws ClassNotFoundException {
    TestModule tm = includedModules.get(0);
    TestSuiteGetter<List<TestSuite>> tsGetter = new TestSuiteList();
    List<TestSuite> testSuiteList = (tm.getTestSuites(tsGetter, testModuleGetter.getModuleData()));
    TestCase tc = testSuiteList.get(0).getTestCases().get(1);
    assertEquals("Log2", tc.getName());
  }
}
