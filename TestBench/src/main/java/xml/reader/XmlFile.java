package xml.reader;

import file_io.FileGetterUsing;

public interface XmlFile {
  public FileGetterUsing getUsing();
  public String getPath();
  public Class<?> getClazz();
  public XmlFileData getFileDataObject();
}
