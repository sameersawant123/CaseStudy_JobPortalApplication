package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.DataNotFoundException;
import com.cg.model.JobUser;
import com.cg.repository.JobPortalRepository;
import com.google.common.base.Optional;

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
	public JobUser addResume(JobUser add) {
		// TODO Auto-generated method stub
		
		JobUser saveResume=JobRepo.save(add);
		return saveResume;  			//add resume
	}


	@Override
	public void deleteJobByuserid(int userid) {
		// TODO Auto-generated method stub
		JobRepo.deleteById(userid);   //delete resume
	}

	@Override
	public JobUser getBycompanyname(String companyname)throws DataNotFoundException {
		Optional<JobUser> p1 = this.JobRepo.findBycompanyname(companyname);
        if (p1.isPresent())
        {
            return p1.get();
        }

        throw new DataNotFoundException();
	}

}
