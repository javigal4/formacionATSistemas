package com.jgb.formacionATSistemas.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgb.formacionATSistemas.model.User;

@Repository
public interface UserDAO extends PagingAndSortingRepository<User, Integer>{
	
	Optional<User> findOneByNameOrderByIdUserDesc(String name);
}
