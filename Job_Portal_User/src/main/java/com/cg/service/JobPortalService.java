package com.cg.service;

import com.cg.exception.DataNotFoundException;
import com.cg.model.JobUser;

public interface JobPortalService {
	
	//to  add new resume/data
		public JobUser addResume(JobUser add);
		
	//to get all Job/company
		public JobUser getBycompanyname(String companyname) throws DataNotFoundException;
		
	//to delete resume
		public void deleteJobByuserid(int userid);
	
}
