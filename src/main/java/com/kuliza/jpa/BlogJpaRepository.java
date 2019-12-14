package com.kuliza.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kuliza.entity.BlogEntity;

@Repository
public interface BlogJpaRepository extends JpaRepository<BlogEntity,Long> {

	@Query("from Blog where userid=?1")
	List<BlogEntity> findAllByUserId(long userId);

}
