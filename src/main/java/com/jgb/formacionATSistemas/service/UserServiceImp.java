package com.jgb.formacionATSistemas.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jgb.formacionATSistemas.dao.UserDAO;
import com.jgb.formacionATSistemas.model.User;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	UserDAO dao;
	
	@Override
	public User create(User user) {
		return dao.save(user);
	}
	
	@Override
	public void update(User user) {
		dao.save(user);
	}
	
	@Override
	public Optional<User> findById(Integer id) {
		return dao.findById(id);
	}
	
	@Override
	public Set<User> findAll(Pageable p) {
		return dao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toSet());
	}
	
	@Override
	public void delete(User user) {
		dao.delete(user);
	}
}
