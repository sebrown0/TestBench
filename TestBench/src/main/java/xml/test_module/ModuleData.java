/**
 * 
 */
package xml.test_module;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import app.TestModuleGetter;
import xml.config_file.Version;
import xml.reader.XmlFileData;

/**
 * @author Brown
 *
 * POJO for the root element of module XML doc. 
 * All other elements are linked/follow this.
 */
@JacksonXmlRootElement(localName = "AppTest")
public class ModuleData implements XmlFileData, TestModuleGetter {  
  @JacksonXmlProperty(localName="forApp")
  private String appName;
  @JacksonXmlProperty(localName="version")
  private Version version;
  @JacksonXmlProperty(localName="appPaths")
  private AppPaths appPaths;
  @JacksonXmlElementWrapper(localName="modules")
  @JacksonXmlProperty(localName="module")
  private List<TestModule> modules;
    
  public ModuleData() {}
  
  @Override
  public XmlFileData get() {
    return this;
  }
  
  @Override
  public List<TestModule> getModules() {
    return modules;
  }
  @Override
  public String getModulePath() {
    return appPaths.getTestModulePath();
  }  
  @Override
  public AppPaths getAppPaths() {
    return appPaths;
  }
  @Override
  public Version getVersion() {
    return version;
  }
  
  public String getAppName() {
    return appName;
  }
  public void setAppName(String forApp) {
    this.appName = forApp;
  }
  
  public void setVersion(Version version) {
    this.version = version;
  }
  
  public void setModules(List<TestModule> modules) {
    this.modules = modules;
  }  
  public void setAppPaths(AppPaths appPaths) {
    this.appPaths = appPaths;
  }

  @Override
  public ModuleData getModuleData() {
    return this;
  }
  
}
