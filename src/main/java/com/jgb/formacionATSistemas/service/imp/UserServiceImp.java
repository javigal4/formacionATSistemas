package com.jgb.formacionATSistemas.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jgb.formacionATSistemas.dao.UserDAO;
import com.jgb.formacionATSistemas.model.User;
import com.jgb.formacionATSistemas.service.UserService;

@Service
public class UserServiceImp implements UserService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1247792739414262076L;
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
	public List<User> findAll(Pageable p) {
		return userDao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toList());
	}
	
	@Override
	public void delete(User user) {
		userDao.delete(user);
	}
}
