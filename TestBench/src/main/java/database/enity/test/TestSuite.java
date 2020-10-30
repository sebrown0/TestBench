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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import database.enity.application.AppModule;

/**
 * Entity for Test Case
 * @author SteveBrown
 * @since 1
 */
@Entity
@Table(name = "test_suite")
public class TestSuite {
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
	@OneToMany(mappedBy = "testSuite")
	private List<TestCase> testCases;
	@OneToMany(mappedBy = "testSuite")
	private List<TestSuiteResult> testSuiteResults;
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "module_name", referencedColumnName = "name"),
		@JoinColumn(name = "module_id", referencedColumnName = "id")
	})
	private AppModule appModule;
	
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
	public List<TestCase> getTestCases() {
		return testCases;
	}
	public List<TestSuiteResult> getTestSuiteResults() {
		return testSuiteResults;
	}
	public AppModule getAppModule() {
		return appModule;
	}
	
}
