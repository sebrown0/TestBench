/**
 * 
 */
package app;

/**
 * @author Brown
 *
 * Get the data from each class of app data, i.e. log, config data and module data.
 */
public interface TestAppDataGetter {
  TestModuleGetter getModuleGetter();
  LogDataGetter getLogDataGetter();
  AppDataGetter getAppDataGetter();
  AppModulePathGetter getAppModulePathGetter();
}
