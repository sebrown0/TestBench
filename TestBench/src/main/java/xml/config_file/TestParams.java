package xml.config_file;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import app.AppDataGetter;

public class TestParams implements AppDataGetter {  
  @JacksonXmlProperty(localName="systemName")
  private String systemName;   
  @JacksonXmlProperty(localName="baseURL")
  private String baseURL;
  @JacksonXmlProperty(localName="driver")
  private String driver;
  @JacksonXmlProperty(localName="version")
  private Version version; 
  
  @Override
  public String getAppName() {
    return systemName;
  }
  @Override
  public String getAppUrl() {
    return baseURL;
  }
  @Override
  public String getAppDriverType() {
    return driver;
  }
  @Override
  public String getAppVersion() {
    return version.toString();
  }
  
  public Version getVersion() {
    return version;
  }
  public void setTestName(String testName) {
    this.systemName = testName;
  }
  public void setBaseURL(String baseURL) {
    this.baseURL = baseURL;
  }
  public void setDriver(String driver) {
    this.driver = driver;
  }
  public void setVersion(Version version) {
    this.version = version;
  }
    
  
}
