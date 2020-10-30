/**
 * 
 */
package app;

/**
 * @author Brown
 *
 */
public class AppModulePath implements AppModulePathGetter{
  private AppDataGetter appDataGetter;  
  private TestModuleGetter testModuleGetter;
  
  public AppModulePath(AppDataGetter appDataGetter, TestModuleGetter testModuleGetter) {
    super();
    this.appDataGetter = appDataGetter;
    this.testModuleGetter = testModuleGetter;
  }

  @Override
  public String getPath() {
    return  testModuleGetter.getModulePath()  +
            appDataGetter.getAppName() + "/" +  appDataGetter.getAppVersion(); 
                
  }

}
