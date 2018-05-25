package com.jgb.formacionATSistemas.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.jgb.formacionATSistemas.dao.AnswerUserDAO;
import com.jgb.formacionATSistemas.model.AnswerUser;

public class AnswerUserServiceImp implements AnswerUserService{

	@Autowired
	AnswerUserDAO answerUserDao;

	@Override
	public AnswerUser create(AnswerUser answerUser) {
		return answerUserDao.save(answerUser);
	}

	@Override
	public void update(AnswerUser answerUser) {
		answerUserDao.save(answerUser);
	}

	@Override
	public Optional<AnswerUser> findById(Integer id) {
		return answerUserDao.findById(id);
	}

	@Override
	public Set<AnswerUser> findAll(Pageable p) {
		return answerUserDao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(AnswerUser answerUser) {
		answerUserDao.delete(answerUser);
		
	}

}
