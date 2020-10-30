/**
 * 
 */
package xml.config_file;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import app.LogDataGetter;

/**
 * @author Brown
 *
 */
public class LogParams implements LogDataGetter{
  @JacksonXmlProperty(localName="useLog")  
  private boolean useLog;
  @JacksonXmlProperty(localName="pathType")  
  private String pathType;
  @JacksonXmlProperty(localName="outputPath")  
  private String outputPath;
  
  @Override
  public boolean isUsingLog() {
    return useLog;
  }
  @Override
  public String getPathType() {
    return pathType;
  }
  @Override
  public String getOutputPath() {
    return outputPath;
  }
  
  public void setUseLog(boolean useLog) {
    this.useLog = useLog;
  }  
  public void setPathType(String pathType) {
    this.pathType = pathType;
  }  
  public void setOutputPath(String outputPath) {
    this.outputPath = outputPath;
  }  
}
