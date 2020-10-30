/**
 * 
 */
package log;

import utils.DateAndTimeStamp;
import utils.DateFormatGeneral;
import utils.TimeFormatModule;

/**
 * @author Brown
 * 
 */
public class EntryTestSuiteEnd implements LogEntryData{
  private String testSuiteName;
  private int testCasesRun;
  private int testCasesFailed;
  private int testCasesIgnored;  
  private static final String description = "Test suite has finished.";
  
  public EntryTestSuiteEnd(
      String testSuiteName, int testCasesRun, int testCasesFailed, int testCasesIgnored) {
    super();
    this.testSuiteName = testSuiteName;    
    this.testCasesRun = testCasesRun;
    this.testCasesFailed = testCasesFailed;
    this.testCasesIgnored = testCasesIgnored;
  }

  @Override
  public String getEntry() {
    String dateAndTime = DateAndTimeStamp.withFormat(
        new DateFormatGeneral(), new TimeFormatModule()).toString();
    
    return String.format(
            "[Test Suite: %s][Date/Time: %s][Test Cases Run: %s][Test Cases Failed: %s][Test Cases Ignored: %s][Description: %s]", 
            testSuiteName, dateAndTime, testCasesRun, testCasesFailed, testCasesIgnored, description);
  }
}
