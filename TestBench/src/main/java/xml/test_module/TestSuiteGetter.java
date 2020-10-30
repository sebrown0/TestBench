/**
 * 
 */
package xml.test_module;

import java.util.List;

/**
 * @author Brown
 *
 * Get a module's test suites.
 */
public interface TestSuiteGetter <T>{
  public T getTestSuites();
  public void setTestSuites(List<TestSuite> testSuites);
  public void setAppData(ModuleData moduleData) ;
  public void setModuleName(String moduleName);
}
