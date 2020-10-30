/**
 * 
 */
package app;

import xml.reader.XmlFilePath;
import xml.reader.XmlFilePathConfigInTest;
import xml.reader.XmlFilePathModulesInTest;

/**
 * @author Brown
 *
 */
public class TestTypeTest implements TestType {

  @Override
  public XmlFilePath getXmlConfigFilePath() {
    return new XmlFilePathConfigInTest();
  }

  @Override
  public XmlFilePath getXmlTestSuiteFilePath() {
    return new XmlFilePathModulesInTest();
  }

}
