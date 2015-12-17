package com.capgemini.databases.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PROJECTS")
public class ProjectsEntity {
	@Id
	@Column(name="PROJECTNAME", length = 150)
	private String projectName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="LEADERPESEL")
	private EmployeesEntity leader;
	
	@Column(name="ISEXTERNAL", nullable = false)
	private boolean isExternal;
	
	@OneToMany(mappedBy = "project")
	private List<ProjectsEngagementEntity> engagements;
	
	public ProjectsEntity() {
		super();
	}

	public ProjectsEntity(String projectName, EmployeesEntity leader, boolean isExternal) {
		super();
		this.projectName = projectName;
		this.leader = leader;
		this.isExternal = isExternal;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public EmployeesEntity getLeader() {
		return leader;
	}

	public void setLeader(EmployeesEntity leaderPesel) {
		this.leader = leaderPesel;
	}

	public boolean getIsExternal() {
		return isExternal;
	}

	public void setIsExternal(boolean isExternal) {
		this.isExternal = isExternal;
	}

	public List<ProjectsEngagementEntity> getEngagements() {
		return engagements;
	}

	public void setEngagements(List<ProjectsEngagementEntity> engagedProjects) {
		this.engagements = engagedProjects;
	}
}
