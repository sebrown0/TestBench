package reports;

public class TestSuiteReport {
	private static TestSuiteResults results;
	
	public static void runReports(TestSuiteResults r) {
		results = r;
		parseReports();
	}
	
	private static void parseReports() {
//	    for (TestSuiteResult result : results.getResults()) {
//			printer(result); //TODO - create interface for printer
//		}
	}
	
	private static void printer(TestSuiteResult result) {
		System.out.println("Test Suite: "+ result.getName());
		System.out.println(
				"Result - Failures: " + result.getResult().getFailureCount() + 
				". Ignored: " +	result.getResult().getIgnoreCount() + 
				". Tests run: " + result.getResult().getRunCount() + 
				". Time: " + result.getResult().getRunTime() + "ms.");
	}
}
