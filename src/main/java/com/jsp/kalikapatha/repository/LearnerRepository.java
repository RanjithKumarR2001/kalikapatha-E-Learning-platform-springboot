package com.jsp.kalikapatha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.kalikapatha.model.Learner;

public interface LearnerRepository extends JpaRepository<Learner, Long> {

	boolean existsByMobile(Long mobile);

	boolean existsByEmail(String email);
	

}
