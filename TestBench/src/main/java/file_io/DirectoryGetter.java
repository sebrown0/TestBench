package file_io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoryGetter {
  private String startingPoint; 
  
  public DirectoryGetter(String startingPoint) {
    super();
    this.startingPoint = startingPoint + "/";
  }

  public List<String> getDirsInStartingPoint() {
    List<String> paths = null;    
    try (Stream<Path> walk = Files.walk(Paths.get(startingPoint))) {
      paths = walk
          .filter(Files::isDirectory)
          .map(x -> x.toString())
          .collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    }  
    return paths;
  }
    
  public String getStartPath() {
    return startingPoint;
  } 

}
