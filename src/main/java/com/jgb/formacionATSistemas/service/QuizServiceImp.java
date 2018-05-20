package com.jgb.formacionATSistemas.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.jgb.formacionATSistemas.dao.QuizDAO;
import com.jgb.formacionATSistemas.model.Course;
import com.jgb.formacionATSistemas.model.Quiz;

public class QuizServiceImp implements QuizService, InitializingBean{

	@Autowired
	QuizDAO quizDao;
	
	public void test() {
		Quiz quiz = new Quiz();
		Course course = new Course();
		
		quiz.setQuiz("Java");
		course.setCourse("Programacion");
		
		quiz.setCourse(course);
		
		quizDao.save(quiz);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
