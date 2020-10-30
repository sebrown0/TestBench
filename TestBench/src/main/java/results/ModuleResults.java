package results;

import java.util.ArrayList;
import java.util.List;

import utils.DateAndTimeStamp;
import utils.DateFormatGeneral;
import utils.TimeFormatModule;

public class ModuleResults {
	private String testerName;
	private String moduleName;
	private DateAndTimeStamp timeStamp;	
	private List<TestSuite> testSuites = new ArrayList<TestSuite>();
	
	public ModuleResults(String testerName, String moduleName) {
		super();
		this.testerName = testerName;
		this.moduleName = moduleName;
		this.timeStamp = DateAndTimeStamp.withFormat(new DateFormatGeneral(), new TimeFormatModule());		
	}
	
	public void addTestSuite(TestSuite ts) {
		testSuites.add(ts);
	}

	public String getTesterName() {
		return testerName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public DateAndTimeStamp getTimeStamp() {
		return timeStamp;
	}

	public List<TestSuite> getTestSuites() {
		return testSuites;
	}
	
}
