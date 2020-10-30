/**
 * 
 */
package xml.reader;

import app.TestAppData;
import file_io.FileGetterUsing;
import file_io.UsingPath;
import xml.test_module.ModuleData;

/**
 * @author Brown
 *
 */
public class ModuleXml implements XmlFile{
  private String xmlFilePath;

  public ModuleXml(TestAppData testAppData) {
    super();
    this.xmlFilePath = testAppData.getModuleXmlFile();
  }
  
  public ModuleXml(String xmlFilePath) {
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
  public Class<?> getClazz() {
    return ModuleData.class;
  }

  @Override
  public XmlFileData getFileDataObject() {
    return new ModuleData();
  }
}
