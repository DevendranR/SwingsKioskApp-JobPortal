package com.dev.persistance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="Applicant")
@SequenceGenerator(name="applicantPKey",sequenceName="hibernate_sequence",allocationSize=1)
public class ApplicantEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="applicantPKey")
	private Integer applicantId;
	private String name;
	private String job;
	private byte[] resume;
	public Integer getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}
	
	
	
	
	
	
	
}
