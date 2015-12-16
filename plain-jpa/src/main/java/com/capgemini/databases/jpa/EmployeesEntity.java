package com.capgemini.databases.jpa;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEES")
public class EmployeesEntity {

	@Id
	@Column(name="PESEL", length = 11)
	String pesel;
	
	@Column(name="LASTNAME", length = 100, nullable = false)
	String lastName;
	
	@Column(name="FIRSTNAME", length = 100, nullable = false)
	String firstName;
	
	@Column(name="BIRTHDATE", columnDefinition = "DATE")
	Date birthDate;
	
	@Column(name="DEPARTMENTNAME", length = 150)
	String departmentName;

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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
