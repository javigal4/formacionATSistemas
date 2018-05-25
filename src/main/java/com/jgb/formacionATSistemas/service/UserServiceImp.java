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
	UserDAO userDao;
	
	@Override
	public User create(User user) {
		return userDao.save(user);
	}
	
	@Override
	public void update(User user) {
		userDao.save(user);
	}
	
	@Override
	public Optional<User> findById(Integer id) {
		return userDao.findById(id);
	}
	
	@Override
	public Set<User> findAll(Pageable p) {
		return userDao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toSet());
	}
	
	@Override
	public void delete(User user) {
		userDao.delete(user);
	}
}
