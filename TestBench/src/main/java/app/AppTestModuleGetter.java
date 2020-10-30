/**
 * 
 */
package app;

import java.util.List;

import file_io.DirectoryGetter;

/**
 * @author Brown
 * Get all the modules dirs in for the app/version.
 * E.g. src\test\java\ts\dakarsoftware\v1_0_0\
 */
public class AppTestModuleGetter {  
  public static List<String> getIncludedDirs(AppModulePathGetter appModulePathGetter){    
    DirectoryGetter dg = new DirectoryGetter(appModulePathGetter.getPath());
    return dg.getDirsInStartingPoint();
  }  
}
