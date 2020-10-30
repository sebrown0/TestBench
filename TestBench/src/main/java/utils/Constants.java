package utils;

public interface Constants {
  public static final String LOG_PATH = "logs/";
  public static final String LOG_NAME = "RESULTS_";
  
  public static final String CONFIG_XML_FILE = "config.xml";
  public static final String MODULE_XML_FILE = "modules.xml";
  
  public static final String CONFIG_XML_PATH_IN_PROD = "src/test/resources/include/";
  public static final String MODULE_XML_PATH_IN_PROD = "src/test/resources/include/";

  public static final String CONFIG_XML_PATH_IN_TEST = "src/main/resources/include/";
  public static final String MODULE_XML_PATH_IN_TEST = "src/main/resources/include/";
  
  public static final String TEST_MODULES_PATH = "src/test/java/";
  public static final String TEST_MODULES_PACKAGE = "ts/";
  public static final String TEST_MODULES_PATH_FULL = TEST_MODULES_PATH + TEST_MODULES_PACKAGE;
}
