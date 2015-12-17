package com.capgemini.databases.jpa.service;

import com.capgemini.databases.jpa.entity.EmployeesEntity;

public interface EmployeeService {
	public EmployeesEntity addEmployee(EmployeesEntity employeeToAdd);
	
	public EmployeesEntity modifyEmployee(EmployeesEntity modifiedEmployee);
}
