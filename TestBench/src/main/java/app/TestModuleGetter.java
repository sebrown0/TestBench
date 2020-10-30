/**
 * 
 */
package app;

import java.util.List;

import xml.config_file.Version;
import xml.test_module.AppPaths;
import xml.test_module.ModuleData;
import xml.test_module.TestModule;

/**
 * @author Brown
 * 
 * Data from the modules file <modules></modules>.
 */
public interface TestModuleGetter {
  ModuleData getModuleData(); 
  List<TestModule> getModules();
  String getModulePath();
  Version getVersion();
  AppPaths getAppPaths();
}
