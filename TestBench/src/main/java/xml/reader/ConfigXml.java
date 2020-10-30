/**
 * 
 */
package xml.reader;

import file_io.FileGetterUsing;
import file_io.UsingPath;
import xml.config_file.ConfigData;

/**
 * @author Brown
 *
 */
public class ConfigXml implements XmlFile{
  private String xmlFilePath;
    
  public ConfigXml(String xmlFilePath) {
    super();
    this.xmlFilePath = xmlFilePath;
  }
  
  @Override
  public FileGetterUsing getUsing() {
    return new UsingPath();
  }

  @Override
  public String getPath() {
    return xmlFilePath;
  }

  @Override
  public Class<ConfigData> getClazz() {
    return ConfigData.class;
  }

  @Override
  public XmlFileData getFileDataObject() {
    return new ConfigData();
  }
}
