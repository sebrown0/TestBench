/**
 * 
 */
package database.enity.application;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import database.enity.test.TestRun;

/**
 * Entity for Version [Application].
 * @author SteveBrown
 * @since 1
 */
@Entity
@Table(name="version", schema = "dakartest")
public class AppVersion implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="major")
	private short major;
	@Column(name="minor")
	private short minor;
	@Column(name="build")
	private short build;	
	@Lob
	@Column(name="notes", columnDefinition = "MEDIUMTEXT")
	private String notes;
	@ManyToOne
	@JoinColumn(name="application_id")
	private Application application;
	@OneToMany(mappedBy = "appVersion")
	private List<AppModule> appModules;
	@OneToMany(mappedBy = "appVersion")
	private List<TestRun> testRuns;
	
	public String getVersionNumber() {
		return String.format("%s_%s_%s", major,minor,build);
	}

	public int getId() {
		return id;
	}

	public short getMajor() {
		return major;
	}

	public short getMinor() {
		return minor;
	}

	public short getBuild() {
		return build;
	}

	public String getNotes() {
		return notes;
	}

	public Application getApplication() {
		return application;
	}

	public List<AppModule> getAppModules() {
		return appModules;
	}

	public List<TestRun> getTestRuns() {
		return testRuns;
	}

	
	
}
