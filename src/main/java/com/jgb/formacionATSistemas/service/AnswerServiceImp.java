package com.jgb.formacionATSistemas.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.jgb.formacionATSistemas.dao.AnswerDAO;
import com.jgb.formacionATSistemas.model.Answer;

public class AnswerServiceImp implements AnswerService {

	@Autowired
	AnswerDAO answerDao;

	@Override
	public Answer create(Answer answer) {
		return answerDao.save(answer);
	}

	@Override
	public void update(Answer answer) {
		answerDao.save(answer);
		
	}

	@Override
	public Optional<Answer> findById(Integer id) {
		return answerDao.findById(id);
	}

	@Override
	public Set<Answer> findAll(Pageable p) {
		return answerDao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Answer answer) {
		answerDao.delete(answer);
		
	}	
	
}
