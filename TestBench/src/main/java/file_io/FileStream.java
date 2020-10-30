package file_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileStream {
  public static String convertToString(java.io.InputStream is) {
    StringBuilder sb = new StringBuilder();
    String line;

    try (BufferedReader br = new BufferedReader(new InputStreamReader(is))){
      while ((line = br.readLine()) != null) {
        sb.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sb.toString();
  }
}
