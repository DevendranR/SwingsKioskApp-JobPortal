package com.dev.persistance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Jobs")
public class JobEntity {
	@Id
	private String jobCode;
	private String jobTitle;
	private String subJob;
	private String jobLevel;
	private String expiryStatus;
	
	public String getJobLevel() {
		return jobLevel;
	}
	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getSubJob() {
		return subJob;
	}
	public void setSubJob(String subJob) {
		this.subJob = subJob;
	}
	public String getExpiryStatus() {
		return expiryStatus;
	}
	public void setExpiryStatus(String expiryStatus) {
		this.expiryStatus = expiryStatus;
	}
	
	
	
	
	
	
	
	
	
}
