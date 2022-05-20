package com.cg.service;

import java.util.List;

import com.cg.exception.JobAlreadyExistsException;
import com.cg.model.JobAdmin;

public interface JobPortalService {

	//to  add new Job
	public JobAdmin addJob(JobAdmin add)throws JobAlreadyExistsException;
	
	//to get all Job
	public List<JobAdmin> getAllJobs();
	
	//to delete job
	public void deleteJobByadmid(int admid);
	
	//To update job
	public JobAdmin updateJob(JobAdmin up);
	
}
