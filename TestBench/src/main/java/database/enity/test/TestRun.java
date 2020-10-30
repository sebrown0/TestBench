/**
 * 
 */
package database.enity.test;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import database.enity.application.AppVersion;
import database.enity.employee.Employee;

/**
 * Entity for a Test Run.
 * @author SteveBrown
 * @since 1
 */
@Entity
@Table(name="test_run")
public class TestRun {	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column(name="tested_on")
	private LocalDateTime testRunTimestamp;	
	@Column(name="description")
	private String description;	
	@Lob @Column(name="notes", columnDefinition = "MEDIUMTEXT")
	private String notes;	
	@ManyToOne		
	@JoinColumns({
		@JoinColumn(name="version_id",referencedColumnName = "id"),
		@JoinColumn(name="version_application_id",referencedColumnName = "application_id")})
	private AppVersion appVersion;	
	@ManyToOne
	@JoinColumn(name="tested_by_employee_id",referencedColumnName = "id")
	private Employee employee;
	@OneToMany(mappedBy = "testRun")
	List<TestSuiteResult> testSuiteResults;
	
	public long getId() {
		return id;
	}
	public LocalDateTime getTestRunTimestamp() {
		return testRunTimestamp; 
	}
	public String getDescription() {
		return description;
	}
	public String getNotes() {
		return notes;
	}
	public AppVersion getAppVersion() {
		return appVersion;
	}
	public Employee getEmployee() {
		return employee;
	}
	public List<TestSuiteResult> getTestSuiteResults() {
		return testSuiteResults;
	}
				
}
