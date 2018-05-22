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
	TagDAO dao;
	
	@Override
	public Tag create(Tag tag) {
		return dao.save(tag);
	}
	
	@Override
	public void update(Tag tag) {
		dao.save(tag);
	}
	
	@Override
	public Optional<Tag> findById(Integer id) {
		return dao.findById(id);
	}
	
	@Override
	public Set<Tag> findAll(Pageable p) {
		return dao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toSet());
	}
	
	@Override
	public void delete(Tag tag) {
		dao.delete(tag);
	}
}
