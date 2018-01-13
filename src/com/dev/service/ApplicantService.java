package com.dev.service;

import java.util.List;

import com.dev.bean.ApplicantDetails;

public interface ApplicantService {
	public String applyForJob(ApplicantDetails details) throws Exception;
	public List<ApplicantDetails> retrieveApplicants() throws Exception;

}
