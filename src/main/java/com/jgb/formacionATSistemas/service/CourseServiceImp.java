package com.jgb.formacionATSistemas.service;

import java.util.Optional;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.jgb.formacionATSistemas.dao.CourseDAO;
import com.jgb.formacionATSistemas.model.Course;

public class CourseServiceImp implements CourseService, InitializingBean {

	@Autowired
	CourseDAO dao;
	
	@Override
	public void testCourse() {
		final Course course = new Course();
		course.setCourse("Curso de ATSISTEMAS");
		dao.save(course);
		final Optional<Course> c = dao.findOneByCourseOrderByIdCourseDesc("Curso de Ingenieria Web");
		System.out.println(c.isPresent() ? c.get() : "no encontrado");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		testCourse();
	}
}
