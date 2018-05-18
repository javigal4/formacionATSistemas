package com.jgb.formacionATSistemas.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgb.formacionATSistemas.model.Course;

@Repository
public interface CourseDAO extends PagingAndSortingRepository<Course, Integer>{
	
	Optional<Course> findOneByNameOrderByIdCourseDesc(String name);
}
