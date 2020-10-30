/**
 * 
 */
package log;

import utils.TimeFormatTest;

/**
 * @author Brown
 * 
 */
public class EntryTestSuiteStart implements LogEntryData{
  private String testSuite;  
  private int testCases;
  private static final String description = "Running test suite.";
      
  public EntryTestSuiteStart(String testSuite, int testCases) {
    super();
    this.testSuite = testSuite;
    this.testCases = testCases;
  }

  @Override
  public String getEntry() {
    String time = TimeFormatTest.formattedTime();    
    return String.format(
            "[Test Suite: %s][Time: %s][Test Cases to Run: %s][Description: %s]", 
            testSuite, time, testCases, description);
  }
}
