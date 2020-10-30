/**
 * 
 */
package database.enity.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity for Test Case Result
 * @author SteveBrown
 * @since 1
 */
@Entity
@Table(name = "test_case_result")
public class TestCaseResult {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "test_passed")
	private byte testPassed;
	@Column(name = "test_ignored")
	private byte testIgnored;
	@Column(name = "comments")
	private String comments;
	@ManyToOne
	@JoinColumn(name = "test_suite_result_id", referencedColumnName = "id")
	private TestSuiteResult testSuiteResult;
	@ManyToOne
	@JoinColumn(name = "test_case_id", referencedColumnName = "id")
	private TestCase testCase;
	
	public int getId() {
		return id;
	}
	public boolean getTestPassed() {
		return (testPassed == 1) ? true : false;
	}
	public byte getTestIgnored() {
		return testIgnored;
	}
	public String getComments() {
		return comments;
	}
	public TestSuiteResult getTestSuiteResult() {
		return testSuiteResult;
	}
	public TestCase getTestCase() {
		return testCase;
	}
	
}
