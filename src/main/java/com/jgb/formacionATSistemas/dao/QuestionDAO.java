package com.jgb.formacionATSistemas.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgb.formacionATSistemas.model.Question;

@Repository
public interface QuestionDAO extends PagingAndSortingRepository<Question, Integer>{
	
	Optional<Question> findOneByQuestionOrderByIdQuestionDesc(String question);
}
