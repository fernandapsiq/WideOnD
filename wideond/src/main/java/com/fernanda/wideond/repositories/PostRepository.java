package com.fernanda.wideond.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernanda.wideond.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
