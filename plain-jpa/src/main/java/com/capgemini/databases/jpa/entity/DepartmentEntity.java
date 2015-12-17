package com.capgemini.databases.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENTS")
public class DepartmentEntity {

	@Id
	@Column(name="DEPARTMENTNAME", length = 150)
	private String departmentName;

	@OneToMany(mappedBy = "department")
	private List<EmployeesEntity> departmentEmployees;
	
	public DepartmentEntity() {
		super();
	}
	
	public DepartmentEntity(String departmentName) {
		super();
		this.departmentName = departmentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public List<EmployeesEntity> getDepartmentEmployees() {
		return departmentEmployees;
	}
	
	public void setDepartmentEmployees(List<EmployeesEntity> departmentEmployees) {
		this.departmentEmployees = departmentEmployees;
	}
}
