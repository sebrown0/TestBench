/**
 * 
 */
package app;

/**
 * @author Brown
 * 
 * Data from the config file <LogParams></LogParams>.
 */
public interface LogDataGetter {
  boolean isUsingLog();
  String getPathType();
  String getOutputPath();  
}
