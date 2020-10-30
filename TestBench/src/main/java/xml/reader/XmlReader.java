package xml.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import file_io.FileStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import file_io.FileGetter;

public class XmlReader {
  private XmlMapper xmlMapper = new XmlMapper();  
  private File file;
  private String xml;  
  private XmlFileData fileData;
  private XmlFile xmlFile;   
  
  public XmlReader(XmlFile xmlFile) {
    super();
    this.xmlFile = xmlFile;
    this.fileData = xmlFile.getFileDataObject();
  }

  public XmlFileData getFileData(){    
    try {
      file = FileGetter.getFile(xmlFile.getPath(), xmlFile.getUsing());    
      xml = FileStream.convertToString(new FileInputStream(file));
      fileData = (XmlFileData) xmlMapper.readValue(xml, xmlFile.getClazz());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return fileData;   
  }
  
}
