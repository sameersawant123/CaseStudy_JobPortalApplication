package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.JobUser;
import com.google.common.base.Optional;

public interface JobPortalRepository extends MongoRepository<JobUser,Integer> {

	public Optional<JobUser> findBycompanyname(String companyname);
}
