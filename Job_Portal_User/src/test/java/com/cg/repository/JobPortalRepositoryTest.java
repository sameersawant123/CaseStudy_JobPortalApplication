package com.cg.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.JobUser;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class JobPortalRepositoryTest 
{
    @Autowired
    private JobPortalRepository joburepo;

    @Test
    public void givenJobUserShouldReturnJobUserObject() 
    {
        JobUser j1=new JobUser(3,"pranay","HR","Tesing","Wipro","IBM","8-4-2022","resume4","BE","Male"); //user input
        joburepo.save(j1); // data saved to database
        JobUser j2=joburepo.findById(j1.getAdmid()).get();//fetching data from database
        assertNotNull(j2); // to check if it is returning job Object
        assertEquals(j1.getAdmname(),j2.getAdmname());
    }

    @Test
    public void getAllmustReturnAllJobUser()
    {
       JobUser j3=new JobUser(1,"Pratik","HR","Tesing","Goa","IBM","8-4-2022","resume4","BE","Male"); //user input
       JobUser j4=new JobUser(2,"Adnya Kudalkar","Manager","Analyst","Mumbai","GreekSoft","8-4-2022","resume5","BSC","Female"); //user input
        joburepo.save(j3); //data saved to database
        joburepo.save(j4); //data saved to database

        List<JobUser> joblist =(List<JobUser>)joburepo.findAll();
        assertEquals(5,joblist.get(1).getAdmid());

    }

}
