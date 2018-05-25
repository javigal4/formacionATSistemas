package com.jgb.formacionATSistemas.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.jgb.formacionATSistemas.dao.TagDAO;
import com.jgb.formacionATSistemas.model.Tag;

public class TagServiceImp implements TagService {
	
	@Autowired
	TagDAO tagDao;
	
	@Override
	public Tag create(Tag tag) {
		return tagDao.save(tag);
	}
	
	@Override
	public void update(Tag tag) {
		tagDao.save(tag);
	}
	
	@Override
	public Optional<Tag> findById(Integer id) {
		return tagDao.findById(id);
	}
	
	@Override
	public Set<Tag> findAll(Pageable p) {
		return tagDao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toSet());
	}
	
	@Override
	public void delete(Tag tag) {
		tagDao.delete(tag);
	}
}
