package arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ArgumentParser {
	private Optional<String> testerName = Optional.empty();
	private List<String> includedModules = new ArrayList<>();
	private List<String> argsList;
	
	public void parseArgs(String[] args) {
//		argsList = new ArrayList<>(Arrays.asList(args));
//		getTesterFromArgs();
//		getIncludedModulesFromArgs();
	}	
	
	private void getTesterFromArgs() {
		if (!argsList.isEmpty()) {
			testerName = Optional.of(argsList.remove(0));
		}
	}
	
	private void getIncludedModulesFromArgs() {
//		for (String s : argsList) {
//			includedModules.add(s);
//		}		
	}

	public String getTesterName() {
		return testerName.orElse("None");
	}

	public List<String> getIncludedModules() {
		return includedModules;
	}
}




