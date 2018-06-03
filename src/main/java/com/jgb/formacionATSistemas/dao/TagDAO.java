package com.jgb.formacionATSistemas.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.Tag;

@Repository
public interface TagDAO extends PagingAndSortingRepository<Tag, Integer>{
	
	Optional<Tag> findOneByTagOrderByIdTagDesc(String tag);
	
	Optional<Tag> findByQuestion(Question question);
	
	List<Tag> findByQuiz(Quiz quiz);
}
