/**
 * 
 */
package app;

import xml.config_file.ConfigData;
import xml.config_file.Version;
import xml.reader.ConfigReader;
import xml.reader.ModuleReader;

/**
 * @author Brown
 *
 * Gets the data from the XML files (on instantiation) according to the params given.
 * Data is retrieved using TestAppDataGetter.
 * TestAppDataGetter can then be passed to the module runner to provide all
 * necessary data.
 */
public class TestAppData implements AppXmlIdentifier, AppVersion, TestAppDataGetter {
  private TestType testType;
  private String testAppName;
  private Version version;  
  private ConfigData configData;
  
  //Below used in TestAppDataGetter
  private TestModuleGetter moduleGetter;
  private LogDataGetter logDataGetter;
  private AppDataGetter appDataGetter;
  
  public TestAppData(String testAppName, Version version, TestType testType) {
    this.testAppName = testAppName;
    this.version = version;
    this.testType = testType;
    readConfigXml();
    readModuleXml();
  }
  
  private void readConfigXml() {
    this.configData = ConfigReader.getConfigData(getConfigXmlFile());
    getTestParameters();
    getLogParameters();
  }
  
  private void getTestParameters() {
    this.appDataGetter = this.configData.getTestParams();    
  }
  
  private void getLogParameters() {
    this.logDataGetter = this.configData.getLogParams();
  }
  
  private void readModuleXml() {
    this.moduleGetter = ModuleReader.getModuleData(getModuleXmlFile());
  }
  
  public String getConfigXmlFile() {
    String configPath = testType.getXmlConfigFilePath().getPath() +  
                        getIdentifier() + testType.getXmlConfigFilePath().getFileName();    
    return configPath;
  }
  
  public String getModuleXmlFile() {
    String modulePath = testType.getXmlTestSuiteFilePath().getPath() +  
                        getIdentifier() + testType.getXmlTestSuiteFilePath().getFileName();
    return modulePath;
  }
  
  public String getName() {
    return testAppName;
  }
  
  public Version getVersion() {
    return version;
  }
  public String getVersionNumber() {
    return version.toString();
  }
  
  @Override
  public String getIdentifier() {
    return this.getName() + "_" + this.getVersionNumber() + "_";
  }

  @Override
  public String getNameAndVersion() {  
    return this.getName() + "/" + this.getVersion().toString();
  }

  @Override
  public TestModuleGetter getModuleGetter() {
    return this.moduleGetter;
  }

  @Override
  public LogDataGetter getLogDataGetter() {
    return this.logDataGetter;
  }

  @Override
  public AppDataGetter getAppDataGetter() {
    return this.appDataGetter;
  }

  @Override
  public AppModulePathGetter getAppModulePathGetter() {
    return new AppModulePath(this.appDataGetter, this.moduleGetter);
  }

}
