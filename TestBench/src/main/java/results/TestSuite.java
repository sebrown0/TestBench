package results;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import utils.Package;

public class TestSuite {
	private String fileName;
	private String moduleName;
	private List<TestResult> results = new ArrayList<TestResult>();
		
	public TestSuite(Object o) {
		super();
		this.moduleName = Package.getName(o);
	}
	
	public TestSuite(String s) {
		super();
		this.moduleName = s;
	}

	public void addResult(TestResult result) {
		this.results.add(result);
	}
	
	private String getFilename() {
		return moduleName + "_" + LocalDate.now() + "_" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
	}
	
	public void PrintResults() {
		System.out.println("File name = " + this.getFilename());
		System.out.println("Test Suite = " + moduleName);
//		for (TestResult testResult : results) {
//			System.out.println("Name = " + testResult.getTestName());
//			System.out.println("PorF = " + testResult.isPassOrFail());
//			System.out.println("Date = " + testResult.getDate());
//			System.out.println("Time = " + testResult.getTime());
//		}
	}
}
