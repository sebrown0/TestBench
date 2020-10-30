package xml.test_module;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TestCase {  
  @JacksonXmlProperty(localName="name")
  private String name;
  
  private boolean passOrFail;
  
  public TestCase() {System.out.println("TestCase");}
  
  public TestCase(String name) {
    super();
    this.name = name;
  }
  
  public boolean isPassOrFail() {
    return passOrFail;
  }
  public void setPassOrFail(boolean passOrFail) {
    this.passOrFail = passOrFail;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}
