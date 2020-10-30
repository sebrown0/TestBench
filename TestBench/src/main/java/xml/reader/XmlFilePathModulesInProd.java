package xml.reader;

import static utils.Constants.*;

public class XmlFilePathModulesInProd implements XmlFilePath{    
  @Override
  public String getPath() {
    return MODULE_XML_PATH_IN_PROD;
  }

  @Override
  public String getFileName() {
    return MODULE_XML_FILE;
  }
}
