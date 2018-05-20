package com.jgb.formacionATSistemas.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgb.formacionATSistemas.model.Result;

@Repository
public interface ResultDAO extends PagingAndSortingRepository<Result, Integer>{
	
	Optional<Result> findOneByDateOrderByIdResultDesc(String result);
}
