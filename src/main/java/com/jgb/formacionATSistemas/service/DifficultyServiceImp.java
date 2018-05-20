package com.jgb.formacionATSistemas.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.jgb.formacionATSistemas.dao.DifficultyDAO;

public class DifficultyServiceImp implements DifficultyService, InitializingBean {

	@Autowired
	DifficultyDAO dao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
