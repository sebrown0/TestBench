package results;

import java.util.List;
import org.openqa.selenium.WebElement;

public class ResultChecker {	
	public static boolean CheckElements(List<WebElement> elements) {
		return elements.size() > 0 ? true : false;
	}
}
