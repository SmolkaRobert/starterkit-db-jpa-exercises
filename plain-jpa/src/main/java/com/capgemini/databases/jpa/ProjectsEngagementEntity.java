package com.capgemini.databases.jpa;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class ProjectsEngagementEntity {
	@Id
	@Column(name="ENGAGEMENTID", length = 20)
	Long engagementId;
	
	@Column(name="EMPLOYEEPESEL", length = 11, nullable = false)
	String employeePesel;
	
	@Column(name="PROJECTFUNCTION", length = 5, nullable = false)
	String projectFunction;
	
	@Column(name="PROJECTNAME", length = 150, nullable = false)
	String projectName;
	
	@Column(name="STARTDATE", columnDefinition = "DATE", nullable = false)
	Date startDate;
	
	@Column(name="ENDDATE", columnDefinition = "DATE")
	Date endDate;
	
	@Column(name="DAILYSALARY", length = 10, nullable = false)
	int dailySalary;

	public Long getEngagementId() {
		return engagementId;
	}

	public void setEngagementId(Long engagementId) {
		this.engagementId = engagementId;
	}

	public String getEmployeePesel() {
		return employeePesel;
	}

	public void setEmployeePesel(String employeePesel) {
		this.employeePesel = employeePesel;
	}

	public String getProjectFunction() {
		return projectFunction;
	}

	public void setProjectFunction(String projectFunction) {
		this.projectFunction = projectFunction;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getDailySalary() {
		return dailySalary;
	}

	public void setDailySalary(int dailySalary) {
		this.dailySalary = dailySalary;
	}
}
