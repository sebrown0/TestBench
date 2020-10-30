/**
 * 
 */
package app;

import xml.config_file.Version;

/**
 * @author Brown
 * 
 * Data from the config file <TestParams></TestParams>.
 */
public interface AppDataGetter {
  String getAppName();
  String getAppVersion();
  String getAppUrl();
  String getAppDriverType();
  Version getVersion();
}
