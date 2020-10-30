/**
 * 
 */
package annotations;

import java.lang.reflect.Method;

/**
 * Get the priority of a TC.
 * @author Brown
 * @since 1
 */
public class PriorityGetter implements ValueGetterForMethod<Priority>{
  @Override
  public Priority getValue(Method method) {
    return method.getAnnotation(TestPriority.class).value();
  }
}
