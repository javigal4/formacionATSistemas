package com.jgb.formacionATSistemas.service;

import java.util.Optional;

import com.jgb.formacionATSistemas.model.Answer;
import com.jgb.formacionATSistemas.model.Question;

public interface AnswerService extends AbstractService<Answer, Integer>{

	Optional<Answer> findByOkisTrueAndQuestion(Question question);
	
}
