package unit_tests.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static utils.Constants.TEST_MODULES_PATH_FULL;

import java.util.List;

import org.junit.Test;

import app.AppDataGetter;
import app.LogDataGetter;
import app.TestAppDataGetter;
import app.TestModuleGetter;
import test_data.AppTestData;
import xml.test_module.TestModule;

public class AppUnderTestTest {
  private static final TestAppDataGetter TEST_DATA_HELPER = TestAppDataHelper.getTestappdata();
  private AppDataGetter appDataGetter = TEST_DATA_HELPER.getAppDataGetter();
  private LogDataGetter logDataGetter = TEST_DATA_HELPER.getLogDataGetter();
  private TestModuleGetter testModuleGetter = TEST_DATA_HELPER.getModuleGetter();
  
  @Test
  public void testModuleGetter() {
    List<TestModule> modules = testModuleGetter.getModules();    
    assertFalse(modules.isEmpty());
  }
  
  @Test
  public void logData_isUsingLog() {  
    assertTrue(logDataGetter.isUsingLog());
  }
  
  @Test
  public void logData_getPathType() {  
    assertEquals("R", logDataGetter.getPathType());
  }
  
  @Test
  public void logData_getOutputPath() {
    assertEquals("logs/", logDataGetter.getOutputPath());
  }
  
  @Test
  public void configData_getAppName() {  
    assertEquals(appDataGetter.getAppName(), TestAppDataHelper.getAppname());
  }
  
  @Test
  public void configData_getAppVersion() {
    assertEquals(appDataGetter.getAppVersion(), TestAppDataHelper.getAppversion());
  }
  
  @Test
  public void configData_getAppUrl() {
    assertEquals(appDataGetter.getAppUrl(), TestAppDataHelper.getAppurl());
  }
  
  @Test
  public void configData_getAppDriverType() {
    assertEquals(appDataGetter.getAppDriverType(), TestAppDataHelper.getAppdriver());
  }
  
  @Test
  public void appName_usingAppDataGetter() {
    assertEquals(appDataGetter.getAppName(), TestAppDataHelper.getAppname());
  }
  
  @Test
  public void appVersion_usingAppDataGetter() {
    assertEquals(appDataGetter.getAppVersion(), TestAppDataHelper.getAppversion());
  }
  
  @Test
  public void modulesPath_usingTestModuleGetter() {
    assertEquals(testModuleGetter.getModulePath(), TEST_MODULES_PATH_FULL);
  }
    
  @Test
  public void appName_usingAppTestData() {
    assertEquals(AppTestData.getApp().getName(), TestAppDataHelper.getAppname());
  }

  @Test
  public void appVersion_usingAppTestData() {    
    assertEquals(AppTestData.getApp().getVersionNumber(), TestAppDataHelper.getAppversion());
  }
  
  @Test
  public void appXmlIdentifier_usingAppTestData() {    
    assertEquals(AppTestData.getApp().getIdentifier(), TestAppDataHelper.getAppname() + "_" + TestAppDataHelper.getAppversion() + "_");
  }
  
}
