package reports;

import java.util.ArrayList;
import java.util.List;

public class TestSuiteResults {
	private List<TestSuiteResult> results = new ArrayList<>();
	
	public void addResult(TestSuiteResult result) {
		results.add(result);
	}

	public List<TestSuiteResult> getResults() {
		return results;
	}
	
}
