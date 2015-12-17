package com.capgemini.databases.jpa.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEES")
public class EmployeesEntity {

	@Id
	@Column(name="PESEL", length = 11)
	private String pesel;
	
	@Column(name="LASTNAME", length = 100, nullable = false)
	private String lastName;
	
	@Column(name="FIRSTNAME", length = 100, nullable = false)
	private String firstName;
	
	@Column(name="BIRTHDATE", columnDefinition = "DATE", nullable = false)
	private Date birthDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="DEPARTMENTNAME")
	private DepartmentEntity department;

	@OneToMany(mappedBy = "projectName")
	private List<ProjectsEntity> leadProjects;
	
	@OneToMany(mappedBy = "employee")
	private List<ProjectsEngagementEntity> engagements;

	public EmployeesEntity() {
		super();
	}

	public EmployeesEntity(String pesel, String lastName, String firstName, Date birthDate, DepartmentEntity department,
			List<ProjectsEntity> leadProjects, List<ProjectsEngagementEntity> engagements) {
		super();
		this.pesel = pesel;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDate = birthDate;
		this.department = department;
		this.leadProjects = leadProjects;
		this.engagements = engagements;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity departmentName) {
		this.department = departmentName;
	}
	
	public List<ProjectsEntity> getLeadProjects() {
		return leadProjects;
	}
	
	public void setLeadProjects(List<ProjectsEntity> leadProjects) {
		this.leadProjects = leadProjects;
	}
}
