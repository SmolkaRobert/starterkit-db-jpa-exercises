package com.capgemini.databases.jpa.service;

import com.capgemini.databases.jpa.entity.EmployeesEntity;
import com.capgemini.databases.jpa.entity.ProjectsEntity;

public interface ProjectService {
	
	public ProjectsEntity addProject(String name, EmployeesEntity leader, boolean external);
}
