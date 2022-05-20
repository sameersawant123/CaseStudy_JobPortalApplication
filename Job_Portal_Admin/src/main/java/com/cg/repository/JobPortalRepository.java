package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cg.model.JobAdmin;

public interface JobPortalRepository extends MongoRepository<JobAdmin, Integer> {

}
