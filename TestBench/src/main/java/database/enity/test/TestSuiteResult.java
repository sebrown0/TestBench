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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity for Test Suite results 
 * @author SteveBrown
 * @since 1
 */
@Entity
@Table(name = "test_suite_result")
public class TestSuiteResult {
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id")
 private int id;
 @Column(name = "result_timestamp")
 private LocalDateTime testedOn;
 @Column(name = "number_test_cases_run")
 private int numTestCasesRun;
 @Column(name = "number_failures")
 private int numFailures;
 @Column(name = "number_passed")
 private int numPassed;
 @Column(name = "number_ignored")
 private int numIgnored;
 @Column(name = "comments")
 private String description;
 @ManyToOne
 @JoinColumn(name = "test_run_id", referencedColumnName = "id")
 private TestRun testRun;
 @OneToMany(mappedBy = "testSuiteResult")
 private List<TestCaseResult> testCaseResults;
 @ManyToOne
 @JoinColumn(name = "test_suite_id", referencedColumnName = "id")
 private TestSuite testSuite;
 
 public int getId() {
	 return id;
 }
 public LocalDateTime getTestedOn() {
	 return testedOn;
 }
 public int getNumTestCasesRun() {
	 return numTestCasesRun;
 }
 public int getNumFailures() {
	 return numFailures;
 }
 public int getNumPassed() {
	 return numPassed;
 }
 public int getNumIgnored() {
	 return numIgnored;
 }
 public String getDescription() {
	 return description;
 }
 public TestRun getTestRun() {
	 return testRun;
 }
 public List<TestCaseResult> getTestCaseResults() {
	 return testCaseResults;
 }
 public TestSuite getTestSuite() {
	 return testSuite;
 }
 
}
