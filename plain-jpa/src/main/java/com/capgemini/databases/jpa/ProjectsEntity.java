package com.capgemini.databases.jpa;

import javax.persistence.Column;
import javax.persistence.Id;

public class ProjectsEntity {
	@Id
	@Column(name="PROJECTNAME", length = 150)
	String projectName;
	
	@Column(name="LEADERPESEL", length = 11, nullable = false)
	String leaderPesel;
	
	@Column(name="ISEXTERNAL", nullable = false)
	boolean isExternal;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getLeaderPesel() {
		return leaderPesel;
	}

	public void setLeaderPesel(String leaderPesel) {
		this.leaderPesel = leaderPesel;
	}

	public boolean getIsExternal() {
		return isExternal;
	}

	public void setIsExternal(boolean isExternal) {
		this.isExternal = isExternal;
	}
}
