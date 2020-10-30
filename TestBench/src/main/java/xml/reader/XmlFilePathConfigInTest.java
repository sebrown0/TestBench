package xml.reader;

import static utils.Constants.*;

public class XmlFilePathConfigInTest implements XmlFilePath{
  
  @Override
  public String getPath() {
    return CONFIG_XML_PATH_IN_TEST;
  }
  
  @Override
  public String getFileName() {
    return CONFIG_XML_FILE;
  }
}

