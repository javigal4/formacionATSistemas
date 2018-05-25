package com.jgb.formacionATSistemas.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.jgb.formacionATSistemas.dao.QuizDAO;
import com.jgb.formacionATSistemas.model.Quiz;

public class QuizServiceImp implements QuizService {

	@Autowired
	QuizDAO quizDao;

	@Override
	public Quiz create(Quiz quiz) {
		return quizDao.save(quiz);
	}

	@Override
	public void update(Quiz quiz) {
		quizDao.save(quiz);
		
	}

	@Override
	public Optional<Quiz> findById(Integer id) {
		return quizDao.findById(id);
	}

	@Override
	public Set<Quiz> findAll(Pageable p) {
		return quizDao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Quiz quiz) {
		quizDao.delete(quiz);	
	}

}
