package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tab2_emp")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer empId;
	@Column(name="name")
	private String empName;
	@Column(name="salary")
	private Double empSalary;
	@Column(name="roles")
	private String empRoles;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpRoles() {
		return empRoles;
	}

	public void setEmpRoles(String empRoles) {
		this.empRoles = empRoles;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empRoles="
				+ empRoles + "]";
	}

}
