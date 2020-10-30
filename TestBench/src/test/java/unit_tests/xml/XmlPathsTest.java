/**
 * 
 */
package unit_tests.xml;

import static org.junit.Assert.*;
import org.junit.Test;
import static test_data.AppTestData.*;

/**
 * @author Brown
 *
 */
public class XmlPathsTest {
    
  @Test
  public void testSuiteInTest() {
    assertEquals(getConfigPath(), CONFIG_PATH_TEST );
  }
  
  @Test
  public void testSuiteInProd() {
    assertEquals(getTestModulePath(), TEST_SUITE_TEST);
  }

}
