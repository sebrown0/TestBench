/**
 * 
 */
package database.enity.application;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity for Application.
 * @author SteveBrown
 * @since 1
 */
@Entity
@Table(name="application")
public class Application {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="date_added")
	private LocalDateTime dateAdded;
	@Lob
	@Column(name="description", columnDefinition = "MEDIUMTEXT")
	private String description;
	@Column(name="last_tested")
	private LocalDateTime lastTested;
	@OneToMany(mappedBy = "application")
	private List<AppVersion> appVersions;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public LocalDateTime getDateAdded() {
		return dateAdded;
	}
	public String getDescription() {
		return description;
	}
	public List<AppVersion> getAppVersions() {
		return appVersions;
	}
	public void setAppVersions(List<AppVersion> appVersions) {
		this.appVersions = appVersions;
	}
	public LocalDateTime getLastTested() {
		return lastTested;
	}
	
}
