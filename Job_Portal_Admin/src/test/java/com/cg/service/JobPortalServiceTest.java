package com.cg.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.SpringBootTest;
import com.cg.exception.JobAlreadyExistsException;
import com.cg.model.JobAdmin;
import com.cg.repository.JobPortalRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class JobPortalServiceTest {

	@Mock
	private JobPortalRepository jpr;
	
	@InjectMocks
	private JobPortalServiceImpl jpsl;
	
	
	@Test
	public void TestAddJob() {
		JobAdmin j1=new JobAdmin(1,"amey","HR","Tesing","Goa","IBM","8-4-2022","resume4","BE","Male");  //user input
		when(jpr.save(any())).thenReturn(j1);
		try {
			jpsl.addJob(j1);
		} catch (JobAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //Data is saved in Database
		verify(jpr,times(1)).save(any());
	}
	
	@Test
	public void testGetAllDepartments()
	{
	JobAdmin j1=new JobAdmin(1,"amey","HR","Tesing","Goa","IBM","8-4-2022","resume4","BE","Male");  //user input
	JobAdmin j2=new JobAdmin(2,"abhi","Manager","Analyst","Pune","Capgemini","8-4-2022","resume3","BE","Male");  //user input
	JobAdmin j3=new JobAdmin(3,"pratik","HR","Web Development","Mumbai","Wipro","8-4-2022","resume2","BE","Male");  //user input
		jpr.save(j1);
		jpr.save(j2);   //saving the info to Database
		jpr.save(j3);	//data saved in database
		List<JobAdmin>jadmList=new ArrayList<>(); //Creating List Object
		jadmList.add(j1);
		jadmList.add(j2);
		jadmList.add(j3);
		
		when(jpr.findAll()).thenReturn(jadmList);
		List<JobAdmin>jadmList1=jpsl.getAllJobs();
		assertEquals(jadmList,jadmList1);
		verify(jpr,times(1)).save(j1);
		verify(jpr,times(1)).findAll();
		
		
	}

}


