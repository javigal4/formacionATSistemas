package com.jgb.formacionATSistemas.service;

import java.util.Optional;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.jgb.formacionATSistemas.dao.TagDAO;
import com.jgb.formacionATSistemas.model.Tag;

public class TagServiceImp implements TagService, InitializingBean {
	
	@Autowired
	TagDAO tagDao;
	
	public void test() {
		final Tag tag = new Tag();
		
		tag.setTag("Spring DATA");
		
		tagDao.save(tag);
		
		final Optional<Tag> t = tagDao.findOneByTagOrderByIdTagDesc("Spring DATA");
		System.out.println(t.isPresent() ? t.get() : "no encontrado");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		test();
	}
}
