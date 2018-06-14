package com.jgb.formacionATSistemas.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgb.formacionATSistemas.model.Answer;
import com.jgb.formacionATSistemas.model.Question;

@Repository
public interface AnswerDAO extends PagingAndSortingRepository<Answer, Integer>{
	
	Optional<Answer> findOneByAnswerOrderByIdAnswerDesc(String Answer);
	
	Optional<Answer> findByOkIsTrue();
	
	Optional<Answer> findByOkTrueAndQuestion(Question question);
}
