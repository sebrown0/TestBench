package utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeFormatFile implements TimeFormatter{
	@Override
	public String getFormattedTime() {		
		return LocalTime.now().format(DateTimeFormatter.ofPattern("HH_mm_ss_SSS"));
	}
}