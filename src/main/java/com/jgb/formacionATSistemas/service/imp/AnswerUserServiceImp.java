package com.jgb.formacionATSistemas.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jgb.formacionATSistemas.dao.AnswerUserDAO;
import com.jgb.formacionATSistemas.model.AnswerUser;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.User;
import com.jgb.formacionATSistemas.service.AnswerUserService;
import com.jgb.formacionATSistemas.service.QuestionService;
import com.jgb.formacionATSistemas.service.QuizService;
import com.jgb.formacionATSistemas.service.UserService;

@Service
public class AnswerUserServiceImp implements AnswerUserService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2263342440186004221L;
	@Autowired
	AnswerUserDAO answerUserDao;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	QuizService quizService;
	
	@Autowired
	UserService userService;

	@Override
	public AnswerUser create(AnswerUser answerUser) {
		return answerUserDao.save(answerUser);
	}

	@Override
	public void update(AnswerUser answerUser) {
		answerUserDao.save(answerUser);
	}

	@Override
	public Optional<AnswerUser> findById(Integer id) {
		return answerUserDao.findById(id);
	}

	@Override
	public List<AnswerUser> findAll(Pageable p) {
		return answerUserDao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(AnswerUser answerUser) {
		answerUserDao.delete(answerUser);
		
	}

	@Override
	public Optional<Question> findQuestionByIdQuestion(Integer idQuestion) {
		return questionService.findById(idQuestion);
	}

	@Override
	public Optional<Quiz> findQuizByIdQuiz(Integer idQuiz) {
		return quizService.findById(idQuiz);
	}

	@Override
	public Optional<User> findUserByIdUser(Integer idUser) {
		return userService.findById(idUser);
	}

}
