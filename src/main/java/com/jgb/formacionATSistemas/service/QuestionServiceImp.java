package com.jgb.formacionATSistemas.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.jgb.formacionATSistemas.dao.QuestionDAO;
import com.jgb.formacionATSistemas.model.Question;

public class QuestionServiceImp implements QuestionService {

	@Autowired
	QuestionDAO questionDao;

	@Override
	public Question create(Question question) {
		return questionDao.save(question);
	}

	@Override
	public void update(Question question) {
		questionDao.save(question);
		
	}

	@Override
	public Optional<Question> findById(Integer id) {
		return questionDao.findById(id);
	}

	@Override
	public Set<Question> findAll(Pageable p) {
		return questionDao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Question question) {
		questionDao.delete(question);
		
	}
	
	
	
}
