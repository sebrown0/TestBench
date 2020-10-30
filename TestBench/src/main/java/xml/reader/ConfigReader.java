/**
 * 
 */
package xml.reader;

import xml.config_file.ConfigData;

/**
 * @author Brown
 * 
 * Reads the xxxx_vx_x_x_config.xml file.
 */
public class ConfigReader {
  private static XmlFileData fileData;
  private static XmlReader xmlReader;
  
  public static ConfigData getConfigData(String configPath) {
    xmlReader = new XmlReader(new ConfigXml(configPath));
    fileData = xmlReader.getFileData();
    return (ConfigData) fileData.get();    
  }
  
}
