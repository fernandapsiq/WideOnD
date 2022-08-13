package com.fernanda.wideond.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernanda.wideond.entities.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
		
}
