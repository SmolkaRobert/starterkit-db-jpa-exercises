package com.capgemini.databases.jpa.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.databases.jpa.entity.EmployeesEntity;
import com.capgemini.databases.jpa.entity.ProjectsEntity;
import com.capgemini.databases.jpa.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {

	public ProjectsEntity addProject(String name, EmployeesEntity leader, boolean external) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("plain-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		ProjectsEntity projectToAdd = new ProjectsEntity(name , leader, external);
		entityManager.persist(projectToAdd);
		transaction.commit();
		
		projectToAdd = entityManager.find(ProjectsEntity.class, projectToAdd.getProjectName());

		entityManager.close();
		entityManagerFactory.close();
		return projectToAdd;
	}
}
