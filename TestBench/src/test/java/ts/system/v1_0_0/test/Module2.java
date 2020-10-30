package ts.system.v1_0_0.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

public class Module2 {

	@Test
	public void passed2() {
	  assertTrue(true);
	}
	
	@Test
  public void failed2() {
    fail("No test case.");
  }
	
	@Test
	@Ignore
  public void ignore2() {
    fail("No test case.");
  }
}
