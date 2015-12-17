package com.capgemini.databases.jpa.service.impl;

import java.sql.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.capgemini.databases.jpa.entity.ProjectsEngagementEntity;

public class ProjectEngagementServiceImplTest

{
	
	@Test
	public void testShouldAddNewEngagement() {
		String pesel = "83071947823";
		String functionName = "DEV";
		String projectName = "newDeathStar";
		Date startDate = Date.valueOf("2015-10-31");
		int dailySalary = 100;
		
		ProjectEngagementServiceImpl service = new ProjectEngagementServiceImpl();
		ProjectsEngagementEntity engagement = service.addEmployeeToProject(pesel, functionName, projectName, startDate, null, dailySalary);
		
		Assertions.assertThat(engagement).isNotNull();
		Assertions.assertThat(engagement.getEmployee().getPesel()).isEqualTo(pesel);
		Assertions.assertThat(engagement.getFunction().getProjectFunction()).isEqualTo(functionName);
		Assertions.assertThat(engagement.getProject().getProjectName()).isEqualTo(projectName);
	}
	
	@Test
	public void testShouldEndEngagement() {
		Long engagementId = 14L;
		Date endDate = Date.valueOf("2015-11-14");
		
		ProjectEngagementServiceImpl service = new ProjectEngagementServiceImpl();
		ProjectsEngagementEntity engagement = service.removeEmployeeFromProject(engagementId, endDate);
		
		Assertions.assertThat(engagement).isNotNull();
		Assertions.assertThat(engagement.getEngagementId()).isEqualTo(engagementId);
		Assertions.assertThat(engagement.getEndDate()).isEqualTo(endDate);
	}
	
	@Test
	public void testShouldGetEngagementsInProject() {
		String projectName = "meteorsOfDoomForSauron";
		Long engagementId = 5L;
		ProjectEngagementServiceImpl service = new ProjectEngagementServiceImpl();
		
		ProjectsEngagementEntity projetEngagement = service.findEngagementById(engagementId);
		List<ProjectsEngagementEntity> engagements = service.findProjectEngagementByLikeCriteria(engagementId);
		
		Assertions.assertThat(engagements).isNotNull();
		Assertions.assertThat(engagements.get(0).getProject().getProjectName()).isEqualTo(projectName);
	}
}
