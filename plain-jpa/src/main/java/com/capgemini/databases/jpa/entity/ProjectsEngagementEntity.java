package com.capgemini.databases.jpa.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PROJECTSENGAGEMENT")
public class ProjectsEngagementEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ENGAGEMENTID", length = 20)
	Long engagementId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="EMPLOYEEPESEL")
	EmployeesEntity employee;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="PROJECTFUNCTION")
	ProjectFunctionsEntity function;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="PROJECTNAME")
	ProjectsEntity project;
	
	@Column(name="STARTDATE", columnDefinition = "DATE", nullable = false)
	Date startDate;
	
	@Column(name="ENDDATE", columnDefinition = "DATE")
	Date endDate;
	
	@Column(name="DAILYSALARY", length = 10, nullable = false)
	int dailySalary;

	public ProjectsEngagementEntity() {
		super();
	}

	public ProjectsEngagementEntity(EmployeesEntity employee, ProjectFunctionsEntity function,
			ProjectsEntity project, Date startDate, Date endDate, int dailySalary) {
		super();
		this.employee = employee;
		this.function = function;
		this.project = project;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dailySalary = dailySalary;
	}

	public Long getEngagementId() {
		return engagementId;
	}

	public void setEngagementId(Long engagementId) {
		this.engagementId = engagementId;
	}

	public EmployeesEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeesEntity employee) {
		this.employee = employee;
	}

	public ProjectFunctionsEntity getFunction() {
		return function;
	}

	public void setFunction(ProjectFunctionsEntity function) {
		this.function = function;
	}

	public ProjectsEntity getProject() {
		return project;
	}

	public void setProject(ProjectsEntity project) {
		this.project = project;
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
