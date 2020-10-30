/**
 * 
 */
package test_data;

import app.TestAppData;
import app.TestTypeTest;
import xml.config_file.Version;
import static utils.Constants.*;
/**
 * @author Brown
 *
 */
public class AppTestData {  
  private static final String MAJOR = "1";
  private static final String MINOR = "0";
  private static final String BUILD = "0";
  private static final String APP_NAME = "system";
//  private static final String APP_NAME = "dakarsoftware";
  
  private static final String PROD_PATH = "src/test/resources/include/" + 
                                          APP_NAME + "_v" + MAJOR + "_" + MINOR + "_" + BUILD + "_";
  private static final String TEST_PATH = "src/main/resources/include/" + 
                                          APP_NAME + "_v" + MAJOR + "_" + MINOR + "_" + BUILD + "_";
  
  private static Version version = new Version(MAJOR,MINOR,BUILD);
  private static TestAppData app = new TestAppData(APP_NAME, version, new TestTypeTest());
  
  public static final String CONFIG_PATH_PROD = PROD_PATH + CONFIG_XML_FILE;      
  public static final String CONFIG_PATH_TEST = TEST_PATH + CONFIG_XML_FILE;  
  public static final String TEST_SUITE_PROD = PROD_PATH + MODULE_XML_FILE;  
  public static final String TEST_SUITE_TEST = TEST_PATH + MODULE_XML_FILE;
  
  
  public static Version getVersion() {
    return version;
  }
  
  public static TestAppData getApp() {
    return app;
  }
  
  public static String getConfigPath() {
    return app.getConfigXmlFile();
  }
  
  public static String getTestModulePath() {
    return app.getModuleXmlFile();
  }
    
}
