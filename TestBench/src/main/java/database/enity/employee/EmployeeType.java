/**
 * 
 */
package database.enity.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * Employee type entity, i.e. developer
 * @author SteveBrown
 * @since 1
 */
@Entity
@Table(name ="employee_type", schema = "dakartest")
public class EmployeeType {
	@Id
	@Column(name="id")
	private String id;	
	@Column(name="type_name")
	private String typeName;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
