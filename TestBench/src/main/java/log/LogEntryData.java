package log;

/*
 * Types of LogEntry:
 *  A. Module level
 *    1. Number tests (suite) to run
 *    2. Test (suite) started
 *    3. Test (suite) ended
 *    
 *  B. Test level
 *    1. Test (case) started
 *    2. Test (case) pass/fail
 *    3. Test (case) ended
 */

//[Module: ][Date/Time: ][Test Cases: ][Description: ]
//[Test Suite: ][Time: ]
//[Test Case: ][Time: ][Pass/Fail: ][Description: ]
public interface LogEntryData {
  public String getEntry();
}
