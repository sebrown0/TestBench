/**
 * 
 */
package annotations;

import java.lang.reflect.Method;

/**
 * Get the description of a TC from annotation.
 * @author Brown
 * @Since 1
 */
public class DescriptionGetter implements ValueGetterForMethod<String>{
  @Override
  public String getValue(Method method) {
    return method.getAnnotation(TestDescription.class).value();
  }    
}
