package com.capgemini.databases.jpa.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.capgemini.databases.jpa.entity.EmployeesEntity;
import com.capgemini.databases.jpa.entity.ProjectFunctionsEntity;
import com.capgemini.databases.jpa.entity.ProjectsEngagementEntity;
import com.capgemini.databases.jpa.entity.ProjectsEntity;
import com.capgemini.databases.jpa.service.ProjectEngagementService;

public class ProjectEngagementServiceImpl implements ProjectEngagementService {

	public ProjectsEngagementEntity addEmployeeToProject(String pesel, String functionName, String projectName,
			Date startDate, Date endDate, int dailySalary) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("plain-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EmployeesEntity employee = entityManager.find(EmployeesEntity.class, pesel);
		ProjectsEntity project = entityManager.find(ProjectsEntity.class, projectName);
		ProjectFunctionsEntity function = entityManager.find(ProjectFunctionsEntity.class, functionName);

		ProjectsEngagementEntity engagementToAdd = new ProjectsEngagementEntity(employee, function, project, startDate, endDate, dailySalary);

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager.persist(engagementToAdd);
		transaction.commit();

		engagementToAdd = entityManager.find(ProjectsEngagementEntity.class, engagementToAdd.getEngagementId());

		entityManager.close();
		entityManagerFactory.close();
		return engagementToAdd;
	}

	public ProjectsEngagementEntity removeEmployeeFromProject(Long engagementId, Date endDate) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("plain-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();


		ProjectsEngagementEntity engagementToEnd = entityManager.find(ProjectsEngagementEntity.class, engagementId);

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		engagementToEnd.setEndDate(endDate);

		entityManager.persist(engagementToEnd);
		entityManager.flush();
		transaction.commit();

		engagementToEnd = entityManager.find(ProjectsEngagementEntity.class, engagementToEnd.getEngagementId());

		entityManager.close();
		entityManagerFactory.close();
		return engagementToEnd;
	}
	
	public ProjectsEngagementEntity findEngagementById(Long engagementId){
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("plain-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		ProjectsEngagementEntity searchedEngagement = entityManager.find(ProjectsEngagementEntity.class, engagementId);
		
		entityManager.close();
		entityManagerFactory.close();
		return searchedEngagement;
	}

	public List<ProjectsEngagementEntity> findProjectEngagementByLikeCriteria(Long projectID) {
		//		engagementId, employeePesel, projectFunction, projectName, startDate, endDate, dailySalary
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("plain-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

//		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<ProjectsEngagementEntity> query = criteriaBuilder.createQuery(ProjectsEngagementEntity.class);
//		Root<ProjectsEngagementEntity> project = query.from(ProjectsEngagementEntity.class);
//		List<Predicate> predicates = new ArrayList<Predicate>();
//		if(employeePesel != null){
//			predicates.add(
//					criteriaBuilder.like(project.get("employee"), employeePesel));
//		}
		
		List<ProjectsEngagementEntity> querriedEngagements = entityManager.createQuery("FROM ProjectsEngagementEntity p WHERE p.engagementId = :id").setParameter("id", projectID).getResultList();

		entityManager.close();
		entityManagerFactory.close();
		
		return querriedEngagements;
	}

}
