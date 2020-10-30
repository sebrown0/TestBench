/**
 * 
 */
package annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Get the value field from an Annotation.
 * @author Brown
 * @since 1
 */
public class AnnotationValue<R> implements ValueGetter<R>{
  private MethodGetter methodGetter;
  private Class<? extends Annotation> anno;
  private ValueGetterForMethod<R> getter;
  
  public AnnotationValue(MethodGetter methodGetter,
      Class<? extends Annotation> anno, ValueGetterForMethod<R> valGetter) {
    
    this.methodGetter = methodGetter;
    this.anno = anno;
    this.getter = valGetter;
  }

  @Override
  public R getValue() {
    R s = null;
    Method m = methodGetter.getMethod();
    if(m.isAnnotationPresent(anno)) {
      s = getter.getValue(m);
    }
    return s;
  }
}
