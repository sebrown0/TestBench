/**
 * 
 */
package xml.config_file;

/**
 * @author Brown
 *
 */
public class Version {  
  private String major;  
  private String minor;  
  private String build;
    
  public Version() {}
  
  public Version(String major, String minor, String build) {
    super();
    this.major = major;
    this.minor = minor;
    this.build = build;
  }
  
  public String getMajor() {
    return major;
  }
  public void setMajor(String major) {
    this.major = major;
  }
  public String getMinor() {
    return minor;
  }
  public void setMinor(String minor) {
    this.minor = minor;
  }
  public String getBuild() {
    return build;
  }
  public void setBuild(String build) {
    this.build = build;
  }

  @Override
  public String toString() {
    return "v" + major + "_" + minor + "_" + build;
  }
}
