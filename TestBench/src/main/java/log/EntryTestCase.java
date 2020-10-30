/**
 * 
 */
package log;

import utils.TimeFormatTest;

/**
 * @author Brown
 * 
 */
public class EntryTestCase implements LogEntryData{
  private String testCase;  
  private String description;
  private boolean passed;
    
  public EntryTestCase(String testCase, String description, boolean passed) {
    super();
    this.testCase = testCase;
    this.description = description;
    this.passed = passed;
  }

  @Override
  public String getEntry() {
    String time = TimeFormatTest.formattedTime();    
    return String.format(
            "[Test Case: %s][Time: %s][Passed: %b][Description: %s]", 
            testCase, time, passed, description);
  }
}
