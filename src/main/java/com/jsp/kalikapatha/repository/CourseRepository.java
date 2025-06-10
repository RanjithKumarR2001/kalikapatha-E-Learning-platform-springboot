package com.jsp.kalikapatha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.kalikapatha.model.Course;
import com.jsp.kalikapatha.model.Tutor;

public interface CourseRepository extends JpaRepository<Course, Long>{

	List<Course> findByTutor(Tutor attribute);

	List<Course> findByPublishedTrue();

}
