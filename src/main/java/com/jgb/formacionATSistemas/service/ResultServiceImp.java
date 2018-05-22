package com.jgb.formacionATSistemas.service;

import org.springframework.beans.factory.InitializingBean;

import com.jgb.formacionATSistemas.dao.ResultDAO;
import com.jgb.formacionATSistemas.model.User;

public class ResultServiceImp implements ResultService, InitializingBean{

	ResultDAO dao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
