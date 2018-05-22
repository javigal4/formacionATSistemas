package com.jgb.formacionATSistemas.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.jgb.formacionATSistemas.dao.ResultDAO;
import com.jgb.formacionATSistemas.model.Result;

public class ResultServiceImp implements ResultService {

	ResultDAO dao;

	@Override
	public Result create(Result result) {
		return dao.save(result);
	}

	@Override
	public void update(Result result) {
		dao.save(result);
		
	}

	@Override
	public Optional<Result> findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public Set<Result> findAll(Pageable p) {
		return dao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Result result) {
		dao.delete(result);
		
	}
}
