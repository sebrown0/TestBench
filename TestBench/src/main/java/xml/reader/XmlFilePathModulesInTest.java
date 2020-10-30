package xml.reader;

import static utils.Constants.*;
import static utils.Constants.MODULE_XML_PATH_IN_TEST;

public class XmlFilePathModulesInTest implements XmlFilePath{
  
  @Override
  public String getPath() {
    return MODULE_XML_PATH_IN_TEST;
  }
  
  @Override
  public String getFileName() {
    return MODULE_XML_FILE;
  }
}
