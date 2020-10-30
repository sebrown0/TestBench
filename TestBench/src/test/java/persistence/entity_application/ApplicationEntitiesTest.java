package persistence.entity_application;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import database.enity.application.AppModule;
import database.enity.application.AppVersion;
import database.enity.application.Application;
import database.enity.test.TestRun;
import database.enity.test.TestSuite;

public class ApplicationEntitiesTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static Application app;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("testBenchPU");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		app = em.find(Application.class, 1);
	} 
	  
	@Test
	public void appName() {
		assertEquals("TestSystem", app.getName());		
	}
	@Test
	public void version_() {
		assertEquals("1_0_1", app.getAppVersions().get(0).getVersionNumber());
	}
	@Test
	public void modules() {
		AppVersion v = app.getAppVersions().get(0);
		AppModule m = v.getAppModules().get(0);
		assertEquals("Module_1", m.getName());
	}
	@Test
	public void getTestSuites() {
		AppVersion v = app.getAppVersions().get(0);
		AppModule m = v.getAppModules().get(0);
		List<TestSuite> testSuites = m.getTestSuites();
		assertTrue(testSuites.size()>0);
	}
	@Test
	public void getTestRuns() {
		AppVersion v = app.getAppVersions().get(0);
		List<TestRun> testRuns = v.getTestRuns();
		assertTrue(testRuns.size()>0);
	}
}
