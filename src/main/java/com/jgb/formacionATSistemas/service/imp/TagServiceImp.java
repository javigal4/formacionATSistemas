package com.jgb.formacionATSistemas.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jgb.formacionATSistemas.dao.TagDAO;
import com.jgb.formacionATSistemas.exception.NotFoundException;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.Tag;
import com.jgb.formacionATSistemas.service.TagService;

@Service
public class TagServiceImp implements TagService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5046988423186458184L;
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
	public List<Tag> findAll(Pageable p) {
		return tagDao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toList());
	}
	
	@Override
	public void delete(Tag tag) {
		tagDao.delete(tag);
	}
	
	@Override
	public Tag findByQuestion(Question question) throws NotFoundException
	{
		Optional<Tag> tag = tagDao.findByQuestion(question);
		if (tag.isPresent())
			return tag.get();
		else
			throw new NotFoundException();
	}

	@Override
	public List<Tag> findByQuiz(Quiz quiz) {
		return tagDao.findByQuiz(quiz);
	}
}
