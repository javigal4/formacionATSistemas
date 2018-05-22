package com.jgb.formacionATSistemas.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.jgb.formacionATSistemas.dao.DifficultyDAO;
import com.jgb.formacionATSistemas.model.Difficulty;

public class DifficultyServiceImp implements DifficultyService {

	@Autowired
	DifficultyDAO difficultyDao;

	@Override
	public Difficulty create(Difficulty difficulty) {
		return difficultyDao.save(difficulty);
	}

	@Override
	public void update(Difficulty difficulty) {
		difficultyDao.save(difficulty);
		
	}

	@Override
	public Optional<Difficulty> findById(Integer id) {
		return difficultyDao.findById(id);
	}

	@Override
	public Set<Difficulty> findAll(Pageable p) {
		return difficultyDao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Difficulty difficulty) {
		difficultyDao.delete(difficulty);
		
	}
	
}
