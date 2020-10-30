package file_io;

import java.io.File;
import java.io.IOException;

public class FileGetter {
  public static File getFile(String filePath, FileGetterUsing fileGetterUsing) throws IOException {
//    System.out.println("file = " + filePath);
    return fileGetterUsing.getFile(filePath);
  }  
}
