package com.jgb.formacionATSistemas.service;

import java.util.List;

import com.jgb.formacionATSistemas.model.Course;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.User;

public interface CourseService extends AbstractService<Course, Integer>{
	
	List<User> findUserById(Integer courseId);
	
	List<Quiz> findQuizById(Integer courseId);
}
