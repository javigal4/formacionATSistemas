package com.jgb.formacionATSistemas.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jgb.formacionATSistemas.dao.AnswerDAO;
import com.jgb.formacionATSistemas.exception.AnswerException;
import com.jgb.formacionATSistemas.model.Answer;

@Service
public class AnswerServiceImp implements AnswerService {

	@Autowired
	AnswerDAO answerDao;

	@Override
	public Answer create(Answer answer) {
		if (answerDao.findByOkIsTrue().isPresent())
			try {
				throw new AnswerException();
			} catch (AnswerException e) {
				e.printStackTrace();
			}
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
	public List<Answer> findAll(Pageable p) {
		return answerDao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Answer answer) {
		answerDao.delete(answer);
		
	}	
	
}
