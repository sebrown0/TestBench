package utils;

import java.util.Optional;

public class TestName {
	public static String get() {
		StackWalker walker = StackWalker.getInstance();
		Optional<String> methodName = 
			walker
				.walk(frames -> frames
				.filter(m -> (m.getMethodName() != "get") && (m.getMethodName() != "CheckElements"))
				.findFirst()
				.map(StackWalker.StackFrame::getMethodName));
		return methodName.orElse("No Test Name");
	}
}
