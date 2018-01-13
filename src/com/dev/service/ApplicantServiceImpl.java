package com.dev.service;

import java.util.List;

import com.dev.bean.ApplicantDetails;
import com.dev.resources.Factory;

public class ApplicantServiceImpl implements ApplicantService{

	@Override
	public String applyForJob(ApplicantDetails details) throws Exception {
		if(details!=null){
			String message = Factory.createApplicantDAO().applyForJob(details);
			return message;
		}
		return null;
	}

	@Override
	public List<ApplicantDetails> retrieveApplicants() throws Exception {
		List<ApplicantDetails> applicantDetails = Factory.createApplicantDAO().retrieveApplicants();
		return applicantDetails;
	}

}
