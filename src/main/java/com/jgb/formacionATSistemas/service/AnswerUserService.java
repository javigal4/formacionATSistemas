package com.jgb.formacionATSistemas.service;

import java.util.Optional;

import com.jgb.formacionATSistemas.model.AnswerUser;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.User;

public interface AnswerUserService extends AbstractService<AnswerUser, Integer>{

	Optional<Question> findQuestionByIdQuestion(Integer idQuestion);
	
	Optional<Quiz> findQuizByIdQuiz(Integer idQuiz);
	
	Optional<User> findUserByIdUser(Integer idUser);
}
