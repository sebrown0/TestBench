package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatGeneral implements DateFormatter{
  private static final String PATTERN = "dd/MM/yyyy";
  
  public static String formatetdDate() {
    return LocalDate.now().format(DateTimeFormatter.ofPattern(PATTERN));
  }
  
	@Override
	public String getFormattedDate() {		
		return LocalDate.now().format(DateTimeFormatter.ofPattern(PATTERN));
	}
}
