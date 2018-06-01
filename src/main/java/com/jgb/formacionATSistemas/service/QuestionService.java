package com.jgb.formacionATSistemas.service;

import java.util.List;
import java.util.Optional;

import com.jgb.formacionATSistemas.model.Answer;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.Tag;

public interface QuestionService extends AbstractService<Question, Integer>{

	public List<Question> findByQuiz(Quiz quiz);
	
	public Tag findTagById(Integer tagId);
	
	public List<Answer> findAnswerById(Integer questionId);
	
	public List<Question> findByTag(Integer tag);
	
	public Answer createAnswer(Answer answer);
}
