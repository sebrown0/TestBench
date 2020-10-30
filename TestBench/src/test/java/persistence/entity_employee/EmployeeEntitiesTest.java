package persistence.entity_employee;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import database.enity.employee.Employee;

public class EmployeeEntitiesTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static Employee emp;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("testBenchPU");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		emp = em.find(Employee.class, new String("SB1"));
	} 
	  
	@Test
	public void employeeName() {
		assertEquals("Brown", emp.getLastName());		
	}
	@Test
	public void employeeEmail_address_1() {
		assertEquals("sbrown@dakarsoftware.com", emp.getEmail().getAddress1());
	}
	@Test
	public void employeeEmail_employeeType() {
		assertEquals("Quality Assurance", emp.getEmployeeType().getTypeName());
	}

}
