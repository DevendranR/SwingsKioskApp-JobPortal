package com.dev.resources;

import com.dev.persistance.dao.ApplicantDAOImpl;
import com.dev.persistance.dao.JobDAOImpl;
import com.dev.service.ApplicantServiceImpl;
import com.dev.service.JobServiceImpl;


public class Factory
{
	public static JobDAOImpl createJobDAO(){
		return new JobDAOImpl();
	}
	public static ApplicantDAOImpl createApplicantDAO(){
		return new ApplicantDAOImpl ();
	}
	public static JobServiceImpl createJobService(){
		return new JobServiceImpl();
	}
	public static ApplicantServiceImpl createApplicantService(){
		return new ApplicantServiceImpl();
	}
}