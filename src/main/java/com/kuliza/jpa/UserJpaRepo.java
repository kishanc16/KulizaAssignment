package com.kuliza.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kuliza.entity.UserEntity;

/**
 * It is user JPA repository which is interacting with database
 * 	
 */
public interface UserJpaRepo extends JpaRepository<UserEntity, Long> {

	@Query("FROM User u WHERE u.id =?1")
	public UserEntity findOne(long userId);
}
