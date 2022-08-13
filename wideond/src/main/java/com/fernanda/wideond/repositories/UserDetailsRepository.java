package com.fernanda.wideond.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernanda.wideond.entities.profiles.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, String>{

}
