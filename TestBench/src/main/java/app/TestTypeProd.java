/**
 * 
 */
package app;

import xml.reader.XmlFilePath;
import xml.reader.XmlFilePathConfigInProd;
import xml.reader.XmlFilePathModulesInProd;

/**
 * @author Brown
 *
 */
public class TestTypeProd implements TestType{

  @Override
  public XmlFilePath getXmlConfigFilePath() {
    return new XmlFilePathConfigInProd();
  }

  @Override
  public XmlFilePath getXmlTestSuiteFilePath() {
    return new XmlFilePathModulesInProd();
  }

}
