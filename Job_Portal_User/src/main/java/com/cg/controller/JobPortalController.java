package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.exception.DataNotFoundException;
import com.cg.model.JobUser;
import com.cg.service.JobPortalService;

@RestController
@RequestMapping("/api/v1")
public class JobPortalController {
	

	private JobPortalService jobServ;
	
	@Autowired
	public JobPortalController(JobPortalService jobServ)
	{
		this.jobServ=jobServ;
	}
	
	
//to add new resume or data
	@PostMapping("/add")
	public ResponseEntity<JobUser>addJobUser(@RequestBody JobUser add) throws DataNotFoundException{
	JobUser savedDept = jobServ.addResume(add);
	return new ResponseEntity<>(savedDept, HttpStatus.CREATED);
	}
		
		
		
//to get all job/company data
	@GetMapping("/company/{companyname}")
	public ResponseEntity<JobUser> getAllcompanyname(@PathVariable String companyname ) throws DataNotFoundException{
	return ResponseEntity.ok().body(jobServ.getBycompanyname(companyname));
	}
		
		
//to delete resume data
		@DeleteMapping("/resume/{userid}")
	public ResponseEntity<Void> deleteByIdJob(@PathVariable int userid)
	{
		jobServ.deleteJobByuserid(userid);
		return ResponseEntity.noContent().build();
	}

}
