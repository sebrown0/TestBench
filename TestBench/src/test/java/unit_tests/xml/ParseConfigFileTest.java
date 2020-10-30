package unit_tests.xml;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import test_data.AppTestData;
import xml.config_file.ConfigData;
import xml.reader.ConfigReader;

public class ParseConfigFileTest{
  private static ConfigData configData;  
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    configData = ConfigReader.getConfigData(AppTestData.getConfigPath());
  }
  
	@Test
	public void configFile_fromTest_useLog() {
    assertEquals(true,configData.getLogParams().isUsingLog());
	}

	@Test
  public void configFile_fromTest_pathType() {
    assertEquals("R",configData.getLogParams().getPathType());
  }

  @Test
  public void configFile_fromTest_outputPath() {
    assertEquals("logs/",configData.getLogParams().getOutputPath());
  }

  @Test
  public void configFile_fromTest_testParam_name() {
    assertEquals("dakarsoftware",configData.getTestParams().getAppName());
  }
  
  @Test
  public void configFile_fromTest_testParam_url() {
    assertEquals("https://www.dakarsoftware.com/",configData.getTestParams().getAppUrl());
  }

  @Test
  public void configFile_fromTest_testParam_driver() {
    assertEquals("chrome",configData.getTestParams().getAppDriverType());
  }
  
  @Test
  public void configFile_fromTest_testParam_version() {
    assertEquals("v1_0_0",configData.getTestParams().getVersion().toString());
  }
}
