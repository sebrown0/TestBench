package unit_tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RunTests {	
	
	public static void main(String[] args) {
//		String url = "jdbc:mysql://localhost?serverTimezone=UTC";
		String url = "jdbc:mysql://localhost/dakartest?serverTimezone=UTC";
		
		try {
//			Class.forName ("com.mysql.jdbc.Driver");//.newInstance ();
			Connection conn = DriverManager.getConnection (url, "root", "root");
			Statement stmt = conn.createStatement();
            stmt.execute("SHOW DATABASES");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            rs.close();
            stmt.close();
            conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
//	  
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testBenchPU");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		Employee emp = em.find(Employee.class, new String("SB1"));
//		System.out.println(emp.getLastName());
//		System.out.println("emp.getLastName()");
	  
	  
	  
//		String[] myArgs = {"Steve Brown", "navigation"}; //TODO - Remove when creating JAR		
//		ArgumentParser parser = new ArgumentParser();
//		parser.parseArgs(myArgs);
//		TestCaseGetter tsGetter = new TestCaseGetter(parser.getIncludedModules());
//		tsGetter.findTestCases();		
//		Class<?>[] classes = tsGetter.getTestCases();
//		assertEquals("TopLeft", classes[0].getSimpleName());
		
//		Arguments appArgs = ArgumentParser.checkArgs(myArgs); // TODO - args
//		TestRunner testRunner = new TestRunner();
//		testRunner.runTests(appArgs.getIncludedTests());
//		TestSuiteReport.runReports(testRunner.getResults());		
	}

}
