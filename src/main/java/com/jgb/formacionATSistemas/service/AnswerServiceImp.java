package com.jgb.formacionATSistemas.service;

import org.springframework.beans.factory.InitializingBean;

import com.jgb.formacionATSistemas.dao.AnswerDAO;

public class AnswerServiceImp implements AnswerService, InitializingBean{

	AnswerDAO dao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub	
	}
}
