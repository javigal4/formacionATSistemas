package com.jgb.formacionATSistemas.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.Tag;

@Repository
public interface QuestionDAO extends PagingAndSortingRepository<Question, Integer>{
	
	//Optional<Question> findOneByQuestionOrderByIdQuestionDesc(String question);
	
	List<Question> findByQuiz(Quiz quiz);
	
	List<Question> findByTag(Integer tag);
}
