package persistence.entity_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import database.enity.application.AppModule;
import database.enity.application.AppVersion;
import database.enity.application.Application;
import database.enity.test.CreationType;
import database.enity.test.Priority;
import database.enity.test.TestCase;
import database.enity.test.TestCaseResult;
import database.enity.test.TestRun;
import database.enity.test.TestSuite;
import database.enity.test.TestSuiteResult;

public class TestEntitiesTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static TestRun testRun;
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("testBenchPU");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		testRun = em.find(TestRun.class, 1l);
	} 
	 
	@Test
	public void testRun_byEmployee() {		
		assertEquals("Steve", testRun.getEmployee().getFirstName());		
	}
	@Test
	public void testRun_timestamp() {		
		assertNotNull(testRun.getTestRunTimestamp());		
	}
	@Test
	public void testRun_Version() {		
		assertEquals("1_0_1", testRun.getAppVersion().getVersionNumber());		
	}
	@Test
	public void testRun_getModule() {
		AppVersion v = testRun.getAppVersion();
		AppModule m = v.getAppModules().get(0);
		assertEquals("Module_1", m.getName());		
	}
	@Test
	public void testRun_appName() {
		AppVersion v = testRun.getAppVersion();
		Application a = v.getApplication();
		assertEquals("TestSystem", a.getName());		
	}
	@Test
	public void testSuiteResult_numCasesRun() {		
		TestSuiteResult tsr = testRun.getTestSuiteResults().get(0);
		assertEquals(2, tsr.getNumTestCasesRun());		
	}
	@Test
	public void testSuiteResult_numFailures() {		
		TestSuiteResult tsr = testRun.getTestSuiteResults().get(0);
		assertEquals(0, tsr.getNumFailures());		
	}
	@Test
	public void testSuiteResult_numIgnored() {		
		TestSuiteResult tsr = testRun.getTestSuiteResults().get(0);
		assertEquals(0, tsr.getNumIgnored());		
	}
	@Test
	public void testSuiteResult_getTestCaseResult() {		
		TestSuiteResult tsr = testRun.getTestSuiteResults().get(0);
		TestCaseResult tcr = tsr.getTestCaseResults().get(0);
		assertEquals(1, tcr.getId());		
	}
	@Test
	public void testCaseResult_getTestCase() {		
		TestSuiteResult tsr = testRun.getTestSuiteResults().get(0);
		TestCaseResult tcr = tsr.getTestCaseResults().get(0);
		TestCase tc = tcr.getTestCase();
		assertEquals("tc_1", tc.getName());		
	}
	@Test
	public void testCaseResult_getPassed() {		
		TestSuiteResult tsr = testRun.getTestSuiteResults().get(0);
		TestCaseResult tcr = tsr.getTestCaseResults().get(0);		
		assertTrue(tcr.getTestPassed());		
	}
	@Test
	public void testCase_getPriority() {		
		TestSuiteResult tsr = testRun.getTestSuiteResults().get(0);
		TestCaseResult tcr = tsr.getTestCaseResults().get(0);
		TestCase tc = tcr.getTestCase();
		Priority p = tc.getPriority();
		assertEquals(Priority.FIVE, p);		
	}
	@Test
	public void testCase_getCreationType() {		
		TestSuiteResult tsr = testRun.getTestSuiteResults().get(0);
		TestCaseResult tcr = tsr.getTestCaseResults().get(0);
		TestCase tc = tcr.getTestCase();
		CreationType type = tc.getCreationType();
		assertEquals(CreationType.AUTO, type);		
	}
	@Test
	public void testSuite_getName() {		
		TestSuiteResult tsr = testRun.getTestSuiteResults().get(0);		
		TestSuite ts = tsr.getTestSuite();
		assertEquals("Test_Suite_1", ts.getName());		
	}
	@Test
	public void testSuite_getModuleName() {		
		TestSuiteResult tsr = testRun.getTestSuiteResults().get(0);		
		AppModule am = tsr.getTestSuite().getAppModule();
		assertEquals("Module_1", am.getName());		
	}
}
