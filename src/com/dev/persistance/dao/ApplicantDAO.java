package com.dev.persistance.dao;

import java.util.List;

import com.dev.bean.ApplicantDetails;


public interface ApplicantDAO {
	public String applyForJob(ApplicantDetails details) throws Exception;
	public List<ApplicantDetails> retrieveApplicants() throws Exception;
}
