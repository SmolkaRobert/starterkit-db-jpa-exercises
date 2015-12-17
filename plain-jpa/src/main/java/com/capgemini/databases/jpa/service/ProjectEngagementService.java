package com.capgemini.databases.jpa.service;

import java.sql.Date;

import com.capgemini.databases.jpa.entity.ProjectsEngagementEntity;

public interface ProjectEngagementService {
	
	public ProjectsEngagementEntity addEmployeeToProject(String pesel, String function, String projectName, Date startDate, Date endDate, int dailySalary);
	
	public ProjectsEngagementEntity removeEmployeeFromProject(Long engagementId, Date endDate);

}
