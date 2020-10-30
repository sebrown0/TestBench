package arguments;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArgumentTest {

	@Test
	public void checkArgs_UserName_NotSupplied() {
		ArgumentParser parser = new ArgumentParser();
		assertEquals("None", parser.getTesterName());
	}
	
	@Test
	public void checkArgs_UserName_Supplied() {
		String[] args = {"Steve Brown"};
		ArgumentParser parser = new ArgumentParser();
		parser.parseArgs(args);		
		assertEquals("Steve Brown", parser.getTesterName());
	}
	
	@Test
	public void checkArgs_TestSuites_Fail() {
		String result;
		String[] args = {"Steve Brown"};
		ArgumentParser parser = new ArgumentParser();
		parser.parseArgs(args);
		result = parser.getIncludedModules().isEmpty() ? "" : "Some value";
		assertEquals("",result);
	}
	
	@Test
	public void checkArgs_TestSuites_Pass() {
		String[] args = {"Steve Brown","login"};
		ArgumentParser parser = new ArgumentParser();
		parser.parseArgs(args);
		assertEquals("login",parser.getIncludedModules().get(0));
	}
	
//	@Test
//	public void checkArgs_TestCasesIn_TestSuite() {
//		int numTestCases = 0;
//		String[] args = {"Steve Brown","utils","login"};
//		Arguments<String> appArgs = ArgumentParser.checkArgs(args);		
//		List<String> testsSuites = appArgs.getIncludedTests(); //package
//		TestSuiteGetter tsGetter = new TestSuiteGetter();
//		Class<?>[] testSuite = tsGetter.getTestSuites();
//		
//		for (String test : testsSuites) {
//			System.out.println(test);
//			for (Class<?> ts : testSuite) {
//				numTestCases = numTestCases + 1;
//				System.out.println(ts.getSimpleName());	
//			}			
//		}		
//		assertEquals(3, numTestCases);
//	}
}
