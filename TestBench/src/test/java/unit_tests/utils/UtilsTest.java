package unit_tests.utils;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import utils.DateAndTimeStamp;
import utils.DateFormatFile;
import utils.DateFormatGeneral;
import utils.DateFormatter;
import utils.TimeFormatFile;
import utils.TimeFormatModule;
import utils.TimeFormatTest;
import utils.TimeFormatter;

public class UtilsTest {

	@Test
	public void timeFormatModule() {
		TimeFormatter tf = new TimeFormatModule();
		assertEquals(8, tf.getFormattedTime().length());
	}
	
	@Test
	public void timeFormatTest() {
		TimeFormatter tf = new TimeFormatTest();
		assertEquals(12, tf.getFormattedTime().length());
	}
	
	@Test
	public void dateFormatGeneral() {
		DateFormatter df = new DateFormatGeneral();
		assertEquals(10, df.getFormattedDate().length());
	}

	@Test
	public void dateAndTimeStamp() {		
		DateAndTimeStamp stamp = DateAndTimeStamp.withFormat(new DateFormatGeneral(), new TimeFormatTest());
		assertEquals(10, stamp.getDate().length());
		assertEquals(12, stamp.getTime().length());
	}	
	
	@Test
	public void dateFileFormat() {
	  DateFormatter df = new DateFormatFile();
	  assertEquals(10, df.getFormattedDate().length());
	}

  @Test
  public void timeFileFormat() {
    TimeFormatter tf = new TimeFormatFile();    
    assertEquals(12, tf.getFormattedTime().length());
  }
	
}
