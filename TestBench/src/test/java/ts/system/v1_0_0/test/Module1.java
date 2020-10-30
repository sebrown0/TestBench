package ts.system.v1_0_0.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.annotation.Retention;

import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;

import annotations.DeveloperAssigned;
import annotations.Priority;
import annotations.TestDescription;
import annotations.TestPriority;
import jdk.jfr.Description;

public class Module1 {

	@Test	
	@TestPriority(value = Priority.FOUR)
	public void passed() {
	  assertTrue(true);
	}
	
	@TestPriority(value = Priority.ONE)
	@DeveloperAssigned(value = "Steve")
	@Test	
  public void failed() {
    fail("No test case.");
  }
	
	@Test
	@TestDescription(value = "This test is ignored")
	@Ignore
  public void ignore() {
    fail("No test case.");
  }
}
