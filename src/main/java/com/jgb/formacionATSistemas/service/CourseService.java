package com.jgb.formacionATSistemas.service;

import java.util.List;
import java.util.Optional;

import com.jgb.formacionATSistemas.model.Answer;
import com.jgb.formacionATSistemas.model.AnswerUser;
import com.jgb.formacionATSistemas.model.Course;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.User;

public interface CourseService extends AbstractService<Course, Integer>{
	
	List<User> findUserById(Integer courseId);
	
	List<Quiz> findQuizById(Integer courseId);
	
	Optional<Quiz> findQuizByIdQuiz(Integer idQuiz);
	
	AnswerUser create(AnswerUser answerUser);
	
	Optional<Answer> findAnswerByOkAndQuestion(Question question);
}
