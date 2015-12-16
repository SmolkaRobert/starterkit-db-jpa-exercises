package com.capgemini.databases.jpa;

import javax.persistence.Column;
import javax.persistence.Id;

public class ProjectFunctionsEntity {
	@Id
	@Column(name="PROJECTFUNCTION", length = 5)
	String projectFunction;

	public String getProjectFunction() {
		return projectFunction;
	}

	public void setProjectFunction(String projectFunction) {
		this.projectFunction = projectFunction;
	}
}
