/**
 * 
 */
package annotations;

import java.lang.reflect.Method;

/**
 * Get a value of type <R>
 * @author Brown
 * @since 1
 */
public interface ValueGetterForMethod<R> {  
  R getValue(Method method);
}
