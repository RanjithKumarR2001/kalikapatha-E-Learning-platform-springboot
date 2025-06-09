package com.jsp.kalikapatha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.kalikapatha.model.Course;
import com.jsp.kalikapatha.model.Section;

public interface SectionRepository extends JpaRepository<Section, Long>{

	List<Section> findByCourse(Course course);

	List<Section> findByCourseIn(List<Course> courses);

}
