package com.jgb.formacionATSistemas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jgb.formacionATSistemas.dao.QuestionDAO;
import com.jgb.formacionATSistemas.exception.NotFoundException;
import com.jgb.formacionATSistemas.model.Answer;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.Tag;

@Service
public class QuestionServiceImp implements QuestionService {

	@Autowired
	QuestionDAO questionDao;
	
	@Autowired
	AnswerService answerService;
	

	@Override
	public Question create(Question question)
	{
		return questionDao.save(question);
	}

	@Override
	public void update(Question question) {
		Optional<Question> questionOpt = questionDao.findById(question.getIdQuestion());
		if (questionOpt.isPresent())
			questionDao.save(question);
		else
			try {
				throw new NotFoundException();
			} catch (NotFoundException e) {}
	}

	@Override
	public Optional<Question> findById(Integer id) {
		return questionDao.findById(id);
	}

	@Override
	public List<Question> findAll(Pageable p) {
		return questionDao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toList());
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
	public Tag findTagById(Integer idQuestion) {
		Optional<Question> question = questionDao.findById(idQuestion);
		System.out.println("ksdnjfHOLAAAAAAAAAAAAAAAA");
		return question.get().getTag();
	}
	
	public List<Answer> findAnswerById(Integer questionId)
	{
		Optional<Question> question = questionDao.findById(questionId);
		return question.get().getAnswer();
	}

	@Override
	public List<Question> findByTag(Integer tag) {
		return questionDao.findByTag(tag);
	}
	
	@Override
	public Answer createAnswer(Answer answer)
	{
		return answerService.create(answer);
	}
	
}
