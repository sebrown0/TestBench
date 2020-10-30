package results;

import org.junit.runner.Result;

import utils.DateFormatGeneral;
import utils.TimeFormatTest;

public class TestResult extends Result{
  private static final long serialVersionUID = 1L;
  private String testName;	
	private String date;
	private String time; 
	private boolean passOrFail;
		
	public TestResult(String testName, boolean passOrFail) {
		super();
		this.testName = testName;
		this.passOrFail = passOrFail;
		this.date = DateFormatGeneral.formatetdDate();
		this.time = TimeFormatTest.formattedTime();
	}
	
	public String getTestName() {
		return testName;
	}
	public boolean isPassOrFail() {
		return passOrFail;
	}
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}	
}
