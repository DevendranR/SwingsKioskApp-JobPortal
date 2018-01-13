package com.dev.persistance.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dev.bean.ApplicantDetails;
import com.dev.persistance.entity.ApplicantEntity;
import com.dev.resources.HibernateUtility;

public class ApplicantDAOImpl implements ApplicantDAO{

	@Override
	public String applyForJob(ApplicantDetails details) throws Exception {
		SessionFactory sessionFactory=null;
		Session session=null;
		try{
			sessionFactory=HibernateUtility.createSessionFactory();
			session=sessionFactory.openSession();
			ApplicantEntity applicantEntity= new ApplicantEntity();
			applicantEntity.setName(details.getName());
			applicantEntity.setJob(details.getJob());
			applicantEntity.setResume(details.getResume());
			session.beginTransaction();
			Integer id = (Integer) session.save(applicantEntity);
			session.getTransaction().commit();
			return "<html>Applied for job successfully with applicantId :"+ id +
					"<br>, you will be contacted soon if shortlisted</html>";
			//return "Applied for job successfully with applicantId :"+ id+", you will be contacted soon if shortlisted";
		}catch (HibernateException e) {
			DOMConfigurator.configure("src/com/dev/resources/log4j.xml");
			Logger logger=Logger.getLogger(this.getClass());
			logger.debug(e.getMessage(),e);
			throw new Exception("DAO.TECHINAL_ERROR");
		} catch (Exception exception) {
			throw exception;
}
		finally {
			if (session.isOpen() || session != null) {
				session.close();
			}
			
		}
	}

	@Override
	public List<ApplicantDetails> retrieveApplicants() throws Exception {
		SessionFactory sessionFactory=null;
		Session session=null;
		try{
			sessionFactory=HibernateUtility.createSessionFactory();
			session=sessionFactory.openSession();
			Query query=session.createQuery("Select ae from ApplicantEntity ae");
			List<ApplicantEntity> applicantList=query.list();
			
			List<ApplicantDetails> alist = new ArrayList<ApplicantDetails>();
			for(ApplicantEntity list:applicantList){
				ApplicantDetails applicantDetails = new ApplicantDetails();
				applicantDetails.setApplicantId(list.getApplicantId());
				applicantDetails.setName(list.getName());
				applicantDetails.setJob(list.getJob());
				applicantDetails.setResume(list.getResume());
				
				alist.add(applicantDetails);
			}
			
			return alist;
		}catch (HibernateException e) {
			DOMConfigurator.configure("src/com/dev/resources/log4j.xml");
			Logger logger=Logger.getLogger(this.getClass());
			logger.debug(e.getMessage(),e);
			throw new Exception("DAO.TECHINAL_ERROR");
		} catch (Exception exception) {
			throw exception;
}
		finally {
			if (session.isOpen() || session != null) {
				session.close();
			}
			
		}
	}

}
