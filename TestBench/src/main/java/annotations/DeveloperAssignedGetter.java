/**
 * 
 */
package annotations;

import java.lang.reflect.Method;

/**
 * Get the developer assigned to a failed TC from annotation.
 * @author Brown
 * @since 1
 */
public class DeveloperAssignedGetter implements ValueGetterForMethod<String>{
  @Override
  public String getValue(Method method) {
    return method.getAnnotation(DeveloperAssigned.class).value();
  }  
}
