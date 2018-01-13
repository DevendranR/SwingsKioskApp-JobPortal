package com.dev.service;

import java.util.List;

import com.dev.bean.Job;
import com.dev.resources.Factory;

public class JobServiceImpl implements JobService{

	@Override
	public String addJob(Job job) throws Exception {
		if(job!=null){
			String message = Factory.createJobDAO().addJob(job);
			return message;
		}
		return null;
		
	}

	@Override
	public String expireJob(String jobCode) throws Exception {
		if(jobCode!=null){
			String message = Factory.createJobDAO().expireJob(jobCode);
			return message;
		}
		return jobCode;
	}

	@Override
	public List<Job> retrieveJobs() throws Exception {
			List<Job> job = Factory.createJobDAO().retrieveJobs();
			return job;
	}

	@Override
	public Job retrieveJobByJobCode(String jobCode) throws Exception {
		Job job = Factory.createJobDAO().retrieveJobByJobCode(jobCode);
		return job;
	}

}
