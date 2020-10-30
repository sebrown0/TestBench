package app;

import java.util.List;

import xml.test_module.TestModule;

/**
 * @author Brown * 
 * Map the test modules from the XML file for the given app/version. 
 */
public class IncludedModulesGetter {
  private List<String> tsDirsInAppBeingTested;
  private List<TestModule> modulesInXml;
  private AppModulePathGetter appModulePathGetter;

       
  public IncludedModulesGetter(
    TestModuleGetter moduleData, AppModulePathGetter appModulePathGetter) {

    this.modulesInXml = moduleData.getModules();
    this.appModulePathGetter = appModulePathGetter;
  }

  public List<TestModule> getIncluded(){
    getTestDirsForApp();
    mapModulesInXmlToModuleObj();
    return modulesInXml;
  }  
  
  private void getTestDirsForApp() {
    tsDirsInAppBeingTested = AppTestModuleGetter.getIncludedDirs(appModulePathGetter);
  }
  
  private void mapModulesInXmlToModuleObj() {
    int idx = tsDirsInAppBeingTested.size() - 1;
    boolean foundDir = false;
    String dir ="";
    for (TestModule tm : modulesInXml) {
      while (idx >= 0 && foundDir==false) {        
        dir = tsDirsInAppBeingTested.get(idx--);
        if (dir.contains(tm.getModuleName())) {
          tm.setModulePath(dir);
          tm.setIncluded(true);
          foundDir=true;
        }
      }
    }  
  }  
}
