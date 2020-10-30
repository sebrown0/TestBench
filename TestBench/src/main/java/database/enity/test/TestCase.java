/**
 * 
 */
package database.enity.test;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import database.enity.employee.Employee;

/**
 * Entity for Test Case
 * @author SteveBrown
 * @since 1
 */
@Entity
@Table(name = "test_case")
public class TestCase {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "last_tested")
	private LocalDateTime lastTested;
	@Column(name = "date_added")
	private LocalDateTime dateAdded;
	@Column(name = "description")
	private String description;
	@Enumerated(EnumType.STRING)
	@Column(name = "priority", columnDefinition = "enum('ONE','TWO','THREE','FOUR','FIVE')")
	private Priority priority;
	@Enumerated(EnumType.STRING)
	@Column(name = "creation_type", columnDefinition = "enum('AUTO','MAN')")
	private CreationType creationType;
	@ManyToOne
	@JoinColumn(name = "developer_assigned_employee_id", referencedColumnName = "id")
	private Employee employee;
	@ManyToOne
	@JoinColumn(name = "test_suite_id", referencedColumnName = "id")
	private TestSuite testSuite;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public LocalDateTime getLastTested() {
		return lastTested;
	}
	public LocalDateTime getDateAdded() {
		return dateAdded;
	}
	public String getDescription() {
		return description;
	}
	public Priority getPriority() {
		return priority;
	}
	public CreationType getCreationType() {
		return creationType;
	}
	public Employee getEmployee() {
		return employee;
	}
	public TestSuite getTestSuite() {
		return testSuite;
	}
}
