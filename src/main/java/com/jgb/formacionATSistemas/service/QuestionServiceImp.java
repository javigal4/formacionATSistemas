package com.jgb.formacionATSistemas.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.jgb.formacionATSistemas.dao.QuestionDAO;

public class QuestionServiceImp implements QuestionService, InitializingBean{

	@Autowired
	QuestionDAO dao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
