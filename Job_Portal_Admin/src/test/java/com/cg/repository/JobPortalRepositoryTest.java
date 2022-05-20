package com.cg.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.JobAdmin;

@SpringBootTest
@ExtendWith(SpringExtension.class)

public class JobPortalRepositoryTest {

@Autowired
private JobPortalRepository jpRepo;

@Test
public void givenJobAdminShouldReturnJobAdminObject(){

	JobAdmin j1 = new JobAdmin (3,"pranay","HR","Tesing","Wipro","IBM","8-4-2022","resume4","BE","Male"); // Input Given By User.
	jpRepo.save(j1); // Given Data is Saved in DataBase.
	JobAdmin j2=jpRepo.findById(j1.getAdmid()).get();
	assertNotNull(j2); // check for returning Library object.
	assertEquals(j1.getAdmid(), j2.getAdmid());
	}
}

