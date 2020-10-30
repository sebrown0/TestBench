package utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeFormatTest implements TimeFormatter{
  private static final String PATTERN = "HH:mm:ss.SSS";
  
  public static String formattedTime() {    
    return LocalTime.now().format(DateTimeFormatter.ofPattern(PATTERN));
  }
  
	@Override
	public String getFormattedTime() {		
		return LocalTime.now().format(DateTimeFormatter.ofPattern(PATTERN));
	}
}