package com.cg.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.exception.JobAlreadyExistsException;
import com.cg.model.JobAdmin;
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
	
//to add new job
	@PostMapping("/add")
	public ResponseEntity<JobAdmin> addJob(@RequestBody JobAdmin add ) throws JobAlreadyExistsException{
		JobAdmin saveddept = jobServ.addJob(add);
	return new ResponseEntity<>(saveddept, HttpStatus.CREATED);
	}		
		
//To update company
		@PutMapping("/update")
	public ResponseEntity<JobAdmin>updateJob(@RequestBody JobAdmin job){
			JobAdmin updatejob=jobServ.updateJob(job);
			return new ResponseEntity<>(updatejob,HttpStatus.CREATED);
		}
		
		
//to get all job data
		@GetMapping("/jobs")
	public ResponseEntity<List<JobAdmin>>getAllJobs(){
	return new ResponseEntity<List<JobAdmin>>((List<JobAdmin>)jobServ.getAllJobs(),HttpStatus.OK);
	}
		
		
//to delete job data
		@DeleteMapping("/job/{admid}")
	public ResponseEntity<Void> deleteByIdJob(@PathVariable int admid){
		jobServ.deleteJobByadmid(admid);
		return ResponseEntity.noContent().build();
	}
}
