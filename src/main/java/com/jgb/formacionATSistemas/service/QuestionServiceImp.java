package com.jgb.formacionATSistemas.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jgb.formacionATSistemas.dao.QuestionDAO;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.Tag;

@Service
public class QuestionServiceImp implements QuestionService {

	@Autowired
	QuestionDAO questionDao;
	
	@Autowired
	TagService tagService;

	@Override
	public Question create(Question question) {
		return questionDao.save(question);
	}

	@Override
	public void update(Question question) {
		questionDao.save(question);
		
	}

	@Override
	public Optional<Question> findById(Integer id) {
		return questionDao.findById(id);
	}

	@Override
	public Set<Question> findAll(Pageable p) {
		return questionDao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Question question) {
		questionDao.delete(question);
		
	}
	
	@Override
	public List<Question> findByQuiz(Quiz quiz)
	{
		return questionDao.findByQuiz(quiz);
	}

	@Override
	public Optional<Tag> findTagById(Integer tagId) {
		return tagService.findById(tagId);
	}
	
}
