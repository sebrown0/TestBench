/**
 * 
 */
package testRunner;

import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import annotations.AnnotationValue;
import annotations.MethodGetter;
import annotations.Priority;
import annotations.PriorityGetter;
import annotations.TestPriority;
import annotations.ValueGetter;

import log.EntryTestCase;
import log.EntryTestSuiteEnd;
import log.EntryTestSuiteStart;
import log.LogEntryData;


/**
 * Listener for test suite (module).
 * <p>
 * The listener collects data for each TC in the TS being run. 
 * @author Brown
 * @since 1
 */
public class TestSuiteListener extends RunListener {
  private List<LogEntryData> logEntries;  
  private String testSuiteName;
  private String currentTestName;
  private boolean currentTestPassed;
  private Failure currentFailure;
  private int testCasesRun;
  private int testCasesFailed;
  private int testCasesIgnored;
  
  private Class<?> clazz;
  
  public TestSuiteListener(Class<?> clazz, List<LogEntryData> logEntries) {
    this.testSuiteName = clazz.getSimpleName();
    this.logEntries = logEntries;
    this.clazz = clazz;
  }
  
  @Override
  public void testRunStarted(Description description) throws java.lang.Exception {    
    testCasesFailed=0;
    addLogEntry(new EntryTestSuiteStart(testSuiteName, description.testCount()));
  }

  @Override
  public void testStarted(Description description) throws java.lang.Exception {
    resetTestCase(description.getMethodName());
    MethodGetter forMethod = new MethodGetter(currentTestName, clazz.getClass().cast(clazz));
    ValueGetter<Priority> p = 
        new AnnotationValue<Priority>(forMethod, TestPriority.class, new PriorityGetter());
    System.out.println(p.getValue());    
  }
  
  private void resetTestCase(String name) {
    currentTestName = name;
    currentTestPassed=true;
    currentFailure=null;
  }

  @Override
  public void testFinished(Description description) throws java.lang.Exception {
    if(currentTestPassed) {
      addLogEntry(new EntryTestCase(currentTestName, "Test case completed ok.", true));  
    }else {
      addLogEntry(new EntryTestCase(currentTestName, currentFailure.getMessage(), false));
    }    
    testCasesRun++;
  }

  @Override
  public void testFailure(Failure failure) throws java.lang.Exception {   
    currentTestPassed=false;
    testCasesFailed++;
    currentFailure=failure;
  }
  
  @Override
  public void testRunFinished(Result result) throws java.lang.Exception {
    addLogEntry(new EntryTestSuiteEnd(testSuiteName, testCasesRun, testCasesFailed, testCasesIgnored));
  }
  
  
  public void testIgnored(Description description) throws java.lang.Exception {
    testCasesIgnored++;
  }
  
  private void addLogEntry(LogEntryData entry)  {
    logEntries.add(entry);
  }
   
}
