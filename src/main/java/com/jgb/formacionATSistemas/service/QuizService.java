package com.jgb.formacionATSistemas.service;

import java.util.List;

import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;

public interface QuizService extends AbstractService<Quiz, Integer> {

	public List<Question> findQuestionByQuiz(Quiz quiz);
}
