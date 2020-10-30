/**
 * 
 */
package xml.test_module;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * @author Brown
 *
 */
public class AppPaths {
  @JacksonXmlProperty(localName="testModuleURL")
  private String testModuleURL;
  @JacksonXmlProperty(localName="testModulePath")
  private String testModulePath;
  
  public AppPaths() {}

  public String getTestModuleURL() {
    return testModuleURL;
  }

  public void setTestModuleURL(String testModuleURL) {
    this.testModuleURL = testModuleURL;
  }

  public String getTestModulePath() {
    return testModulePath;
  }

  public void setTestModulePath(String testModulePath) {
    this.testModulePath = testModulePath;
  }
}
