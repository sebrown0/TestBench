/**
 * 
 */
package database.enity.employee;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;

import database.enity.test.TestRun;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Employee entity
 * @author SteveBrown
 * @since 1
 */
@Entity
@Table(name ="employee", schema = "dakartest")
public class Employee {
	@Id
	@Column(name="id")
	private String id;	
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	
	@OneToOne(mappedBy="employee")
	Email email;
	@OneToOne()
	@JoinColumn(name="employee_type_id")
	EmployeeType employeeType;
	@OneToMany(mappedBy="employee")
	private List<TestRun> testRuns;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}
	
}
