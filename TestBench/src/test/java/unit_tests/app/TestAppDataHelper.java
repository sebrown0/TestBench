/**
 * 
 */
package unit_tests.app;

import app.TestAppData;
import app.TestAppDataGetter;
import app.TestType;
import app.TestTypeTest;
import xml.config_file.Version;

/**
 * @author Brown
 *
 */
public class TestAppDataHelper {
  private static final String appName = "system";
  private static final String appVersion = "v1_0_0";
  private static final String appUrl = "https://www.dakarsoftware.com/";
  private static final String appDriver = "chrome";
  
  private static final Version version = new Version("1","0","0");
  private static final TestType testType = new TestTypeTest();
  private static final TestAppDataGetter testAppData = 
      new TestAppData(appName, version, testType);
  
  
  public static String getAppname() {
    return appName;
  }
  public static String getAppversion() {
    return appVersion;
  }
  public static String getAppurl() {
    return appUrl;
  }
  public static String getAppdriver() {
    return appDriver;
  }
    
  public static TestAppDataGetter getTestappdata() {
    return testAppData;
  }  
}
