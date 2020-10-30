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
public class EntryModuleEnd implements LogEntryData{
  private String module;
  private int testCasesRun;
  private int testCasesFailed;
  private int testCasesIgnored;  
  private static final String description = "Testing of app has finished.";
  
  public EntryModuleEnd(
      String module, int testCasesRun, int testCasesFailed, int testCasesIgnored) {
    super();
    this.module = module;    
    this.testCasesRun = testCasesRun;
    this.testCasesFailed = testCasesFailed;
    this.testCasesIgnored = testCasesIgnored;
  }

  @Override
  public String getEntry() {
    String dateAndTime = DateAndTimeStamp.withFormat(
        new DateFormatGeneral(), new TimeFormatModule()).toString();
    
    return String.format(
            "[Test App: %s][Date/Time: %s][Test Cases Run: %s][Test Cases Failed: %s][Test Cases Ignored: %s][Description: %s]", 
            module, dateAndTime, testCasesRun, testCasesFailed, testCasesIgnored, description);
  }
}
