package testRunner;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;

import app.AppModulePathGetter;
import app.IncludedModulesGetter;
import app.LogDataGetter;
import app.TestAppDataGetter;
import app.TestModuleGetter;
import log.EntryModuleStart;
import log.EntrySimpleModuleEnd;
import log.LogEntryData;
import log.LogFile;
import reports.TestSuiteResults;
import xml.test_module.ModuleData;
import xml.test_module.TestModule;
import xml.test_module.TestSuiteClass;
import xml.test_module.TestSuiteGetter;

public class ModuleRunner {
	private TestSuiteResults results = new TestSuiteResults();
	private LogFile log;
  private LogDataGetter logDataGetter;
  private TestModuleGetter testModuleGetter;
  private AppModulePathGetter appModulePathGetter;
  private List<LogEntryData> logEntries = new ArrayList<LogEntryData>();
  JUnitCore runner = new JUnitCore();
//  private String logPath;  
	
  public ModuleRunner(TestAppDataGetter testAppData) {
    this.logDataGetter = testAppData.getLogDataGetter();
    this.testModuleGetter = testAppData.getModuleGetter(); 
    this.appModulePathGetter = testAppData.getAppModulePathGetter();
//    this.logPath = LogFile.getFilePathAndName();
  }

  public void writeLogEntry(List<LogEntryData> logEntries) {
    log.writeEntries(logEntries);
  }
  
  public void runTestModules() {
    IncludedModulesGetter modules = new IncludedModulesGetter(testModuleGetter, appModulePathGetter);    
		for (TestModule testModule : modules.getIncluded()) {
		  if(moduleShouldBeRun(testModule)) {
		    runModule(testModule);
		  }		  
    }
	}
  
  /*
   * If the the module name was not found in the module path
   * don't run the module.   
   * 
   * I.e. the specified module in the XML file doesn't exist on the path.   *  
   */
  private boolean moduleShouldBeRun(TestModule testModule) {
    return testModule.isIncluded();  
  }
  
  private void runModule(TestModule testModule) {
    String moduleName = testModule.getModuleName();
    log = new LogFile(logDataGetter, moduleName);
    logEntries.add(new EntryModuleStart(moduleName));
    runTestSuites(testModule);
    logEntries.add(new EntrySimpleModuleEnd(moduleName));
    writeLogEntry(logEntries);
  }
  
  private void runTestSuites(TestModule testModule) {
    Class<?>[] testSuitesAsClass = getTestSuitesAsClass(testModule);
    TestSuiteListener listener;
    
    for(int idx=0; idx < testSuitesAsClass.length; idx++) {      
      listener = new TestSuiteListener(testSuitesAsClass[idx], logEntries);
      runner.addListener(listener);
      runner.run(testSuitesAsClass[idx]);
      runner.removeListener(listener);
    }
  }  
  
  private Class<?>[] getTestSuitesAsClass(TestModule testModule){    
    TestSuiteGetter<Class<?>[]> tsGetter = new TestSuiteClass();
    ModuleData moduleData = testModuleGetter.getModuleData();
    Class<?>[] testSuiteClasses = testModule.getTestSuites(tsGetter, moduleData);    
    return testSuiteClasses;
  }
		
	public TestSuiteResults getResults() {
		return results;
	}
}
