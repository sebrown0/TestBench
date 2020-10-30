/**
 * 
 */
package xml.test_module;

import java.util.List;

/**
 * @author Brown
 *
 */
public class TestSuiteList  implements TestSuiteGetter<List<TestSuite>> {
  private List<TestSuite> testSuites;
  @SuppressWarnings("unused")
  private ModuleData moduleData;
  @SuppressWarnings("unused")
  private String moduleName;

  @Override
  public List<TestSuite> getTestSuites() {    
    return testSuites;        
  }
  
  @Override
  public void setTestSuites(List<TestSuite> testSuites) {
    this.testSuites = testSuites;
  }
  @Override
  public void setAppData(ModuleData moduleData) {
    this.moduleData = moduleData;
  }
  @Override
  public void setModuleName(String moduleName) {
    this.moduleName = moduleName;
  }
}
