package com.jsp.kalikapatha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.kalikapatha.model.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long>{

	boolean existsByMobile(Long mobile);

	boolean existsByEmail(String email);

}
