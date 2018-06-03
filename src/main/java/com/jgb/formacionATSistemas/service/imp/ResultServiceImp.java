package com.jgb.formacionATSistemas.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jgb.formacionATSistemas.dao.ResultDAO;
import com.jgb.formacionATSistemas.model.Result;
import com.jgb.formacionATSistemas.service.ResultService;

@Service
public class ResultServiceImp implements ResultService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8049445544124997698L;
	ResultDAO resultDao;

	@Override
	public Result create(Result result) {
		return resultDao.save(result);
	}

	@Override
	public void update(Result result) {
		resultDao.save(result);
		
	}

	@Override
	public Optional<Result> findById(Integer id) {
		return resultDao.findById(id);
	}

	@Override
	public List<Result> findAll(Pageable p) {
		return resultDao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Result result) {
		resultDao.delete(result);
	}
}
