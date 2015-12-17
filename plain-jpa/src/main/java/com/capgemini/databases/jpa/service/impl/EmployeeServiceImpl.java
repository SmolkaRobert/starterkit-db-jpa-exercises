package com.capgemini.databases.jpa.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.databases.jpa.entity.EmployeesEntity;
import com.capgemini.databases.jpa.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	public EmployeesEntity addEmployee(EmployeesEntity employeeToAdd) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("plain-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.persist(employeeToAdd);
		transaction.commit();
		
		EmployeesEntity employee = entityManager.find(EmployeesEntity.class, employeeToAdd.getPesel());

		entityManager.close();
		entityManagerFactory.close();
		return employee;
	}

	public EmployeesEntity modifyEmployee(EmployeesEntity modifiedEmployee) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("plain-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EmployeesEntity employee = entityManager.find(EmployeesEntity.class, modifiedEmployee.getPesel());

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		if(modifiedEmployee.getBirthDate() != null){
			employee.setBirthDate(modifiedEmployee.getBirthDate());
		}
		if(modifiedEmployee.getDepartment() != null){
			employee.setDepartment(modifiedEmployee.getDepartment());
		}
		if(modifiedEmployee.getFirstName() != null){
			employee.setFirstName(modifiedEmployee.getFirstName());
		}
		if(modifiedEmployee.getLastName() != null){
			employee.setLastName(modifiedEmployee.getLastName());
		}
		if(modifiedEmployee.getLeadProjects() != null){
			employee.setLeadProjects(modifiedEmployee.getLeadProjects());
		}
		
		entityManager.persist(employee);
		entityManager.flush();
		transaction.commit();

		entityManager.close();
		entityManagerFactory.close();
		return employee;
	}

}
