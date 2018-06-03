package com.jgb.formacionATSistemas.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgb.formacionATSistemas.model.Quiz;

@Repository
public interface QuizDAO extends PagingAndSortingRepository<Quiz, Integer>{
	
	Optional<Quiz> findOneByQuizOrderByIdQuizDesc(String quiz);
	
}
