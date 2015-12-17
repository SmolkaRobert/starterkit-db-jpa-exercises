package com.capgemini.databases.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PROJECTFUNCTIONS")
public class ProjectFunctionsEntity {
	@Id
	@Column(name="PROJECTFUNCTION", length = 5)
	private String projectFunction;

	@OneToMany(mappedBy = "function")
	private List<ProjectsEngagementEntity> engagements;
	
	public String getProjectFunction() {
		return projectFunction;
	}

	public void setProjectFunction(String projectFunction) {
		this.projectFunction = projectFunction;
	}

	public List<ProjectsEngagementEntity> getEngagements() {
		return engagements;
	}

	public void setEngagements(List<ProjectsEngagementEntity> projectsEngaged) {
		this.engagements = projectsEngaged;
	}
}
