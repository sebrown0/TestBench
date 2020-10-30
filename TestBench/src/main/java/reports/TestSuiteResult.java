package reports;

import org.junit.runner.Result;

public class TestSuiteResult {
	private String name;
	private boolean testSuiteRun;
	private Result result;
	
	public TestSuiteResult(String name) {
    super();
    this.name = name; 
  }

  public TestSuiteResult(String name, Result result, boolean testSuiteRun) {
    super();
    this.name = name;
    this.testSuiteRun = testSuiteRun;
    this.result = result;
  }

  public String getName() {
    return name;
  }  
  public boolean isTestSuiteRun() {
    return testSuiteRun;
  }
  public void setTestSuiteRun(boolean testSuiteRun) {
    this.testSuiteRun = testSuiteRun;
  }
  public Result getResult() {
    return result;
  }
  public void setResult(Result result) {
    this.result = result;
  }	
}
