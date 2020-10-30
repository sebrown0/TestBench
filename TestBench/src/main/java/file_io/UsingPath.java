package file_io;

import java.io.File;

public class UsingPath implements FileGetterUsing{
  @Override
  public File getFile(String filePath) {    
    File file = new File(filePath); 
    return file;  
  }
}
