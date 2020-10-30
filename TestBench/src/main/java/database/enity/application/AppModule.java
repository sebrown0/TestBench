/**
 * 
 */
package database.enity.application;

import java.io.Serializable;
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

import database.enity.test.TestSuite;
/**
 * Email entity
 * @author SteveBrown
 * @since 1
 */
@Entity
@Table(name ="module", schema = "dakartest")
public class AppModule implements Serializable{	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;	
	@Column(name="name")
	private String name;
	@Column(name="last_tested")
	private LocalDateTime lastTested;
	@Column(name="date_added")
	private LocalDateTime dateAdded;
	@Column(name="description")
	private String description;
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="version_id",referencedColumnName = "id"),
		@JoinColumn(name="version_application_id",referencedColumnName = "application_id")})
	private AppVersion appVersion;
	@OneToMany(mappedBy = "appModule")
	List<TestSuite> testSuites;
	
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
	public AppVersion getAppVersion() {
		return appVersion;
	}
	public List<TestSuite> getTestSuites() {
		return testSuites;
	}
}
