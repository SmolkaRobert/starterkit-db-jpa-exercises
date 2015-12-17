package com.capgemini.databases.jpa.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.databases.jpa.entity.EmployeesEntity;
import com.capgemini.databases.jpa.entity.ProjectsEntity;

public class ProjectServiceImplTest

{
	private EmployeesEntity projectLeader;
	private String projectName;
	private boolean external;
	private String leaderPesel;
	@Before
	public void testInit(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("plain-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		leaderPesel = "73051156789";
		projectLeader = entityManager.find(EmployeesEntity.class, leaderPesel );
		projectName = "newChainsawForJason";
		external = true;
	}
	
	@Test
	public void testShouldAddNewProject() {
		ProjectServiceImpl service = new ProjectServiceImpl();
		ProjectsEntity project = service.addProject(projectName, projectLeader, external);
		
		Assertions.assertThat(project).isNotNull();
		Assertions.assertThat(project.getProjectName()).isEqualTo(projectName);
	}
}
