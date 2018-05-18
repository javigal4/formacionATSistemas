package com.jgb.formacionATSistemas.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgb.formacionATSistemas.dao.UserDAO;
import com.jgb.formacionATSistemas.model.User;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService, InitializingBean {
	
	@Autowired
	UserDAO dao;
	
	@Override
	public void test() {
		final User user = new User();
		user.setEmail("asdf@gmail.com");
		user.setName("Javi");
		user.setPassword("javi123");
		dao.save(user);
		final Optional<User> u = dao.findOneByNameOrderByIdUserDesc("Pepe 1");
		System.out.println(u.isPresent() ? u.get() : "no encontrado");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		test();
		
	}
}
