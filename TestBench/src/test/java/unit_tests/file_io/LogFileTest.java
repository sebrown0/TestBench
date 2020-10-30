package unit_tests.file_io;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import app.LogDataGetter;
import app.TestAppData;
import app.TestType;
import app.TestTypeTest;
import log.EntryModuleEnd;
import log.EntryModuleStart;
import log.EntryTestCase;
import log.EntryTestSuiteStart;
import log.LogEntryData;
import log.LogFile;
import xml.config_file.Version;

public class LogFileTest {
//  private List<TestResult> results = new ArrayList<TestResult>();    
  private static final String appName = "dakarsoftware";
  private static final String moduleName = "login";
  
  private Version version = new Version("1","0","0");
  private TestType testType = new TestTypeTest();
  private LogDataGetter logDataGetter = new TestAppData(appName, version, testType).getLogDataGetter();
  private LogFile log = new LogFile(logDataGetter, moduleName);
  private String logPath = log.getFilePathAndName();
  private List<LogEntryData> logEntries = new ArrayList<>();  
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }
    
  @Test
  public void write_ModuleStart() throws IOException {
    addLogEntry(new EntryModuleStart("login"));
    writeLogEntry();
  }

  @Test
  public void read_ModuleStart() throws IOException {
    addLogEntry(new EntryModuleStart("login"));
    writeLogEntry();
    String line = readLineFromFile(1);
    assertEquals("[Module: login]", line.substring(0,15));
  }
  
  @Test
  public void read_ModuleEnd() throws IOException {
    addLogEntry(new EntryModuleEnd("login", 3, 0, 0));
    writeLogEntry();
    String line = readLineFromFile(1);
    assertEquals("[Module: login]", line.substring(0,15));
  }

  @Test
  public void read_ModuleStart_End() throws IOException {
    addLogEntry(new EntryModuleStart("login"));
    addLogEntry(new EntryModuleEnd("login", 3, 0, 0));
    writeLogEntry();
    String line = readLineFromFile(2);
    assertEquals("[Description: Module has finished.]", line.substring(111));
  }
  
  @Test
  public void read_TestSuite() throws IOException {
    addLogEntry(new EntryTestSuiteStart("OpenHomePage",2));    
    writeLogEntry();
    String line = readLineFromFile(2);
    assertEquals("[Test Suite: OpenHomePage]", line.substring(0,26));
  }
  
  @Test
  public void read_TestCase() throws IOException {
    addLogEntry(new EntryTestCase("TC1", "description", true));    
    writeLogEntry();
    String line = readLineFromFile(2);
    assertEquals("[Test Case: TC1]", line.substring(0,16));
  }
  
  private void addLogEntry(LogEntryData entry) throws IOException {
    logEntries.add(entry);
    log.writeEntries(logEntries);
  }
  
  private void writeLogEntry() throws IOException {
    log.writeEntries(logEntries);
  }
  
  private String readLineFromFile(int lineNum) throws FileNotFoundException, IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(logPath), StandardCharsets.UTF_8));) {

      String line;
      String retLine = null;
      int idx = 0;
      
      while ((line = br.readLine()) != null && lineNum != idx) {
        retLine = line;
      }
      return retLine;
    }
  }
}
