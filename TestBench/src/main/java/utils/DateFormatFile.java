package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatFile implements DateFormatter{
	@Override
	public String getFormattedDate() {		
	  String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy"));
		return date;
	}
}
