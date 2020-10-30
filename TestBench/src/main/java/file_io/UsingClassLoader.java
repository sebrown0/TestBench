package file_io;

import java.io.File;

public class UsingClassLoader implements FileGetterUsing{

  @Override
  public File getFile(String filePath) {
    ClassLoader classLoader = getClass().getClassLoader();    
    return new File(classLoader.getResource(filePath).getFile()); 
  }
}
