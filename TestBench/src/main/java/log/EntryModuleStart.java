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
public class EntryModuleStart implements LogEntryData{
  private String module;
  private static final String description = "Starting module.";
    
  public EntryModuleStart(String module) {
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
