package com.dev.persistance.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dev.bean.Job;
import com.dev.persistance.entity.JobEntity;
import com.dev.resources.HibernateUtility;

public class JobDAOImpl implements JobDAO{

	@Override
	public String addJob(Job job) throws Exception {
		SessionFactory sessionFactory=null;
		Session session=null;
		try{
			sessionFactory=HibernateUtility.createSessionFactory();
			session=sessionFactory.openSession();
			
			JobEntity jobEntity= new JobEntity();
			jobEntity.setJobCode(job.getJobCode());
			jobEntity.setSubJob(job.getSubJob());
			jobEntity.setJobLevel(job.getJobLevel());
			jobEntity.setJobTitle(job.getJobTitle());
			jobEntity.setExpiryStatus("No");
			session.beginTransaction();
			session.save(jobEntity);
			session.getTransaction().commit();
			
			return "job added successfully";
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
	public String expireJob(String jobCode) throws Exception {
		SessionFactory sessionFactory=null;
		Session session=null;
		try{
			sessionFactory=HibernateUtility.createSessionFactory();
			session=sessionFactory.openSession();
			session.beginTransaction();
			Query query=session.createQuery("Select je from JobEntity je where je.jobCode=?");
			query.setParameter(0, jobCode);
			JobEntity jobEntity=(JobEntity) query.list().get(0);
			jobEntity.setExpiryStatus("Yes");
			session.save(jobEntity);
			session.getTransaction().commit();
			
			return "Job Expired Successfully";
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
	public List<Job> retrieveJobs() throws Exception {
		SessionFactory sessionFactory=null;
		Session session=null;
		try{
			sessionFactory=HibernateUtility.createSessionFactory();
			session=sessionFactory.openSession();
			Query query=session.createQuery("Select je from JobEntity je");
			List<JobEntity> jobList=query.list();
			List<Job> jList = new ArrayList<Job>();
			for (JobEntity job : jobList) {
				Job job2 = new Job();
				job2.setJobCode(job.getJobCode());
				job2.setSubJob(job.getSubJob());
				job2.setJobTitle(job.getJobTitle());
				job2.setJobLevel(job.getJobLevel());
				job2.setExpiryStatus(job.getExpiryStatus());
				jList.add(job2);
			}
			return jList;
			
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
	public Job retrieveJobByJobCode(String jobCode) throws Exception {
		SessionFactory sessionFactory=null;
		Session session=null;
		try{
			sessionFactory=HibernateUtility.createSessionFactory();
			session=sessionFactory.openSession();
			Query query=session.createQuery("Select je from JobEntity je where je.jobCode=?");
			query.setParameter(0, jobCode);
			JobEntity jobEntity=(JobEntity) query.list().get(0);
			Job job = new Job();
			
				job.setJobCode(jobEntity.getJobCode());
				job.setSubJob(jobEntity.getSubJob());
				job.setJobTitle(jobEntity.getJobTitle());
				job.setJobLevel(jobEntity.getJobLevel());
				job.setExpiryStatus(jobEntity.getExpiryStatus());
				
			
			return job;
			
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
