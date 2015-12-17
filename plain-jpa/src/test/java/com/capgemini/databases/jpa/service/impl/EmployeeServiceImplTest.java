package com.capgemini.databases.jpa.service.impl;

import java.sql.Date;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.capgemini.databases.jpa.entity.DepartmentEntity;
import com.capgemini.databases.jpa.entity.EmployeesEntity;

public class EmployeeServiceImplTest

{
	@Test
	public void testShouldAddNewEmployee() {
		String pesel = "83071947823";
		String lastName = "Klecina";
		String firstName = "Maria";
		Date birthDate = Date.valueOf("1983-07-19");
		DepartmentEntity department = new DepartmentEntity("Support");
		
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		EmployeesEntity employee = new EmployeesEntity(pesel, lastName, firstName , birthDate, department, null, null);
		employee = service.addEmployee(employee);
		
		Assertions.assertThat(employee).isNotNull();
		Assertions.assertThat(employee.getPesel()).isEqualTo(pesel);
	}
	
	@Test
	public void testShouldModifyEmployee() {
		String newLastName = "Abera-Kolin";
		EmployeesEntity employee = new EmployeesEntity("91112901234", newLastName, null, null, null, null, null);
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		employee = service.modifyEmployee(employee);
		
		Assertions.assertThat(employee).isNotNull();
		Assertions.assertThat(employee.getLastName()).isEqualTo(newLastName);
	}
}
