package com.fernanda.wideond.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernanda.wideond.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

}
