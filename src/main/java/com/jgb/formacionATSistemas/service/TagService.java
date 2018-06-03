package com.jgb.formacionATSistemas.service;

import java.util.List;

import com.jgb.formacionATSistemas.exception.NotFoundException;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.Tag;

public interface TagService extends AbstractService<Tag, Integer>{
	
	Tag findByQuestion(Question question) throws NotFoundException;
	
	public List<Tag> findByQuiz(Quiz quiz);
}
