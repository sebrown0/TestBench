/**
 * 
 */
package log;

import utils.DateAndTimeStamp;
import utils.DateFormatGeneral;
import utils.TimeFormatModule;

/**
 * @author Brown
 * 
 */
public class EntrySimpleModuleEnd implements LogEntryData{
  private String module;  
  private static final String description = "Testing of app has finished.";
  
  public EntrySimpleModuleEnd(String module) {
    super();
    this.module = module;    
  }

  @Override
  public String getEntry() {
    String dateAndTime = DateAndTimeStamp.withFormat(
        new DateFormatGeneral(), new TimeFormatModule()).toString();
    
    return String.format(
            "[Test App: %s][Date/Time: %s][Description: %s]", 
            module, dateAndTime, description);
  }
}
