package com.jgb.formacionATSistemas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jgb.formacionATSistemas.dao.QuizDAO;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;

@Service
public class QuizServiceImp implements QuizService {

	@Autowired
	QuizDAO quizDao;
	
	@Autowired
	QuestionService questionService;

	@Override
	public Quiz create(Quiz quiz) {
		return quizDao.save(quiz);
	}

	@Override
	public void update(Quiz quiz) {
		quizDao.save(quiz);
		
	}

	@Override
	public Optional<Quiz> findById(Integer id) {
		return quizDao.findById(id);
	}

	@Override
	public List<Quiz> findAll(Pageable p) {
		return quizDao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Quiz quiz) {
		quizDao.delete(quiz);	
	}
	
	public List<Question> findQuestionByQuiz(Quiz quiz)
	{
		return questionService.findByQuiz(quiz);
	}

}
