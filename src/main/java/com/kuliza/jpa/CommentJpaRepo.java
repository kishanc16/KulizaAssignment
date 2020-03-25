package com.kuliza.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kuliza.entity.CommentEntity;

@Repository
public interface CommentJpaRepo extends JpaRepository<CommentEntity,Long> {

}
