/**
 * 
 */
package xml.config_file;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import xml.reader.XmlFileData;

/**
 * @author Brown
 *
 * Root of config.xml
 */
@JacksonXmlRootElement(localName = "Config")
public class ConfigData implements XmlFileData {
  @JacksonXmlProperty(localName="TestParams")  
  private TestParams testParams;
  @JacksonXmlProperty(localName="LogParams")
  private LogParams logParams;  
  
  public TestParams getTestParams() {
    return testParams;
  }
  public void setTestParams(TestParams testParams) {
    this.testParams = testParams;
  }
  public LogParams getLogParams() {
    return logParams;
  }
  public void setLogParams(LogParams logParams) {
    this.logParams = logParams;
  }
  @Override
  public XmlFileData get() {
    return this;
  }
}
