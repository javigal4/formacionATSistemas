package com.jgb.formacionATSistemas.service;

import java.util.List;
import java.util.Optional;

import com.jgb.formacionATSistemas.model.Course;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.Tag;

public interface QuizService extends AbstractService<Quiz, Integer> {

	public List<Question> findQuestionByQuiz(Quiz quiz);
	
	public List<Tag> findTagByQuiz(Quiz quiz);
	
	public Optional<Course> findCourseByIdCourse(Integer idCourse);
}
