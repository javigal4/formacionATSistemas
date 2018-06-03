package com.jgb.formacionATSistemas.service;

import java.util.List;

import com.jgb.formacionATSistemas.exception.NotFoundException;
import com.jgb.formacionATSistemas.model.Answer;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.Tag;

public interface QuestionService extends AbstractService<Question, Integer>{

	public List<Question> findByQuiz(Quiz quiz);
	
	public Tag findTag(Question question) throws NotFoundException;
	
	public List<Answer> findAnswerById(Integer questionId);
	
	public List<Question> findByTag(Integer tag);
	
	public Answer createAnswer(Answer answer);
}
