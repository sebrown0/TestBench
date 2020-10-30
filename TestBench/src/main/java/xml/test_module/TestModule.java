package xml.test_module;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TestModule {
  @JacksonXmlProperty(localName="name")  
  private String name;
  @JacksonXmlElementWrapper(localName="testSuites")
  @JacksonXmlProperty(localName="testSuite")
  private List<TestSuite> testSuites = new ArrayList<>();
  
  private String modulePath;
  private boolean isIncluded;
  
  public <T> T getTestSuites(TestSuiteGetter<T> testSuiteGetter, ModuleData moduleData){
    testSuiteGetter.setAppData(moduleData);
    testSuiteGetter.setModuleName(name);
    testSuiteGetter.setTestSuites(testSuites);
    return testSuiteGetter.getTestSuites();
  }

  public boolean isIncluded() {
    return isIncluded;
  }

  public void setIncluded(boolean isIncluded) {
    this.isIncluded = isIncluded;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setTestSuites(List<TestSuite> testSuites) {
    this.testSuites = testSuites;
  }

  public void setModulePath(String modulePath) {
    this.modulePath = modulePath;
  }

  public String getModulePath() {
    return modulePath;
  }

  public String getModuleName() {
    return name;
  }
    
}
