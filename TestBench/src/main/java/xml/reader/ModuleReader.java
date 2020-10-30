/**
 * 
 */
package xml.reader;

import xml.test_module.ModuleData;

/**
 * @author Brown
 * 
 * Reads the xxxx_vx_x_x_config.xml file.
 */
public class ModuleReader {
  private static XmlFileData fileData;
  private static XmlReader xmlReader;
  
  public static ModuleData getModuleData(String moduleXmlPath) {
    xmlReader = new XmlReader(new ModuleXml(moduleXmlPath));    
    fileData =  xmlReader.getFileData();    
    return (ModuleData) fileData.get();    
  }
  
}
