/**
 * 
 */
package annotations;

import java.lang.reflect.Method;

/**
 * Get the method for given method name and class.
 * @author Brown
 * @since 1
 */
public class MethodGetter {
  private String methodName;
  private Class<?> fromClazz;
  
  public MethodGetter(String methodName, Class<?> fromClazz) {
    super();
    this.methodName = methodName;
    this.fromClazz = fromClazz;
  }

  public Method getMethod() {    
    Method m = null;
    try {
      m = fromClazz.getMethod(methodName);
    } catch (NoSuchMethodException | SecurityException e) {
      System.out.printf("Method [%s] for class [%s] could not be found.", 
          methodName, fromClazz.getCanonicalName()); //TODO Add to log if implemented.
    }
    return m;    
  }
}
