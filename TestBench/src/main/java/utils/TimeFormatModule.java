package utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeFormatModule implements TimeFormatter{
	@Override
	public String getFormattedTime() {		
		return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}
}
