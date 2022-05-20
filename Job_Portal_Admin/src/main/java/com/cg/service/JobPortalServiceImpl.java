package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.JobAlreadyExistsException;
import com.cg.model.JobAdmin;
import com.cg.repository.JobPortalRepository;

@Service
public class JobPortalServiceImpl implements JobPortalService {

	private JobPortalRepository JobRepo;
	
	@Autowired
	public JobPortalServiceImpl(JobPortalRepository jobRepo) {
		super();
		// TODO Auto-generated constructor stub
		this.JobRepo=jobRepo;
	}
	
	@Override
	
	public JobAdmin addJob(JobAdmin add) throws JobAlreadyExistsException {
		// TODO Auto-generated method stub
		if(JobRepo.existsById(add.getAdmid()))
		{
			throw new JobAlreadyExistsException();
		}
		   //add job
		return JobRepo.save(add);                
	}

	@Override
	public List<JobAdmin> getAllJobs() {
		// TODO Auto-generated method stub
		return (List<JobAdmin>)JobRepo.findAll();  //list of job
	}

	@Override
	public void deleteJobByadmid(int admid) {
		// TODO Auto-generated method stub
		JobRepo.deleteById(admid);   //delete job

	}

	@Override
	public JobAdmin updateJob(JobAdmin up) {
		// TODO Auto-generated method stub
		return JobRepo.save(up);    //update job
	}

}