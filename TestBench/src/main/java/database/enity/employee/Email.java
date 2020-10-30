/**
 * 
 */
package database.enity.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * Email entity
 * @author SteveBrown
 * @since 1
 */
@Entity
@Table(name ="email", schema = "dakartest")
public class Email {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")	
	private int id;	
	@Column(name="address_1")
	private String address1;
	@Column(name="address_2")
	private String address2;
	
	@OneToOne
	private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}			
}
