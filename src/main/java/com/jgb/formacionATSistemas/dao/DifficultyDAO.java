package com.jgb.formacionATSistemas.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgb.formacionATSistemas.model.Difficulty;

@Repository
public interface DifficultyDAO extends PagingAndSortingRepository<Difficulty, Integer>{
	
	Optional<Difficulty> findOneByDifficultyOrderByIdDifficultyDesc(String difficulty);
}
