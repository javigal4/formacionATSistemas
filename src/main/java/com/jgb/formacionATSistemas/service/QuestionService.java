package com.jgb.formacionATSistemas.service;

import java.util.List;
import java.util.Optional;

import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.Tag;

public interface QuestionService extends AbstractService<Question, Integer>{

	public List<Question> findByQuiz(Quiz quiz);
	
	public Optional<Tag> findTagById(Integer tagId);
}
