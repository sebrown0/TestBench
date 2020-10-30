package xml.test_module;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TestSuite {
  @JacksonXmlProperty(localName="name")
  private String name;  
  @JacksonXmlElementWrapper(localName = "testCases")
  @JacksonXmlProperty(localName="testName")
  private List<TestCase> testCases = new ArrayList<>();
    
  private boolean passOrFail;
  
  public TestSuite() {}

  public TestSuite(String name) {
    this.name = name;
  }

  public Class<?> getClazz(String classPath) throws ClassNotFoundException {
    Class<?> clazz = null;
    clazz = Class.forName(classPath + this.name);
    return clazz;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<TestCase> getTestCases() {
    return testCases;
  }

  public void setTestCases(List<TestCase> testCases) {
    this.testCases = testCases;
  }

  public boolean isPassOrFail() {
    return passOrFail;
  }

  public void setPassOrFail(boolean passOrFail) {
    this.passOrFail = passOrFail;
  }

}
