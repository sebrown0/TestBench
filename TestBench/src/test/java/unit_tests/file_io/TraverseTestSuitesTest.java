package unit_tests.file_io;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import file_io.DirectoryGetter;

import static utils.Constants.*;

import java.util.List;

public class TraverseTestSuitesTest {
  private static final String testSuiteName = "dakarsoftware/v1_0_0";
  private DirectoryGetter directoryGetter = new DirectoryGetter(TEST_MODULES_PATH_FULL + testSuiteName);
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {  
  }

  @Test
  public void path() {
    assertEquals(TEST_MODULES_PATH + TEST_MODULES_PACKAGE, TEST_MODULES_PATH_FULL);
  }
  
  @Test
  public void getPathsToIncludedTestSuites() {    
    List<String> paths = directoryGetter.getDirsInStartingPoint();
    assertFalse(paths.isEmpty());
  }

}
