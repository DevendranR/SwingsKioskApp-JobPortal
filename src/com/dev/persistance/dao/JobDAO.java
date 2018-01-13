package com.dev.persistance.dao;

import java.util.List;

import com.dev.bean.ApplicantDetails;
import com.dev.bean.Job;

public interface JobDAO {
	public String addJob(Job job) throws Exception;
	public String expireJob(String jobCode) throws Exception;
	public List<Job> retrieveJobs() throws Exception;
	public Job retrieveJobByJobCode(String jobCode) throws Exception;
}
