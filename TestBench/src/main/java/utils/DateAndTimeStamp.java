package utils;

public class DateAndTimeStamp {
	private String date;
	private String time;
	
	private DateAndTimeStamp(String date, String time) {
		super();
		this.date = date;
		this.time = time;
	}

	public static DateAndTimeStamp withFormat(DateFormatter df, TimeFormatter tf) {
		return new DateAndTimeStamp(df.getFormattedDate(), tf.getFormattedTime());
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	@Override
	public String toString() {
		return date + "_" + time;
	}
	
}
