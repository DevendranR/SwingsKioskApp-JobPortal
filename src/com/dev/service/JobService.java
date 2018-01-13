package com.dev.service;

import java.util.List;

import com.dev.bean.Job;

public interface JobService {
	public String addJob(Job job) throws Exception;
	public String expireJob(String jobCode) throws Exception;
	public List<Job> retrieveJobs() throws Exception;
	public Job retrieveJobByJobCode(String jobCode) throws Exception;
}
