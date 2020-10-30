package unit_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import annotations.AnnotationValue;
import annotations.DescriptionGetter;
import annotations.DeveloperAssigned;
import annotations.DeveloperAssignedGetter;
import annotations.MethodGetter;
import annotations.Priority;
import annotations.PriorityGetter;
import annotations.TestDescription;
import annotations.TestPriority;
import annotations.ValueGetter;
import ts.system.v1_0_0.test.Module1;

public class Annotations {

  @Test
  public void priority() {
    MethodGetter forMethod = new MethodGetter("passed", Module1.class);
    ValueGetter<Priority> p = 
        new AnnotationValue<Priority>(forMethod, TestPriority.class, new PriorityGetter());
    assertEquals(Priority.FOUR, p.getValue());
  }
  
  @Test
  public void description() {
    MethodGetter forMethod = new MethodGetter("ignore", Module1.class);
    ValueGetter<String> desc = 
        new AnnotationValue<String>(forMethod, TestDescription.class, new DescriptionGetter());
    assertEquals("This test is ignored", desc.getValue());
  }

  @Test
  public void developer() {
    MethodGetter forMethod = new MethodGetter("failed", Module1.class);
    ValueGetter<String> dev = 
        new AnnotationValue<String>(forMethod, DeveloperAssigned.class, new DeveloperAssignedGetter());
    assertEquals("Steve", dev.getValue());
  }
}
