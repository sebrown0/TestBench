package log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import app.LogDataGetter;
import file_io.FileGetterUsing;
import file_io.UsingClassLoader;
import utils.DateFormatFile;
import utils.DateFormatter;
import utils.TimeFormatFile;
import utils.TimeFormatter;

public class LogFile {  
  private String filePathAndName;
  private FileGetterUsing classLoader = new UsingClassLoader();
  private TimeFormatter tf = new TimeFormatFile();
  private DateFormatter df = new DateFormatFile();
  
  public LogFile(LogDataGetter logDataGetter, String moduleName) {
    try {      
      String logPath = classLoader.getFile(logDataGetter.getOutputPath()).getAbsolutePath();
      filePathAndName = 
          logPath + "\\" + moduleName + "_" +
          df.getFormattedDate() + "_" +
          tf.getFormattedTime() +
          ".txt";      
    } catch (IOException e) {      
      e.printStackTrace();
    }      
  }
  
  public void writeEntries(List<LogEntryData> logEntries) {    
    try (PrintWriter writer = new PrintWriter(new FileWriter(filePathAndName))) {
      for (LogEntryData entry : logEntries) {
        writer.println(entry.getEntry());        
      }
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }
  
  public String getFilePathAndName() {
    return filePathAndName;
  }
}
