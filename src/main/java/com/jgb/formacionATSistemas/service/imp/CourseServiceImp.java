package com.jgb.formacionATSistemas.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jgb.formacionATSistemas.dao.CourseDAO;
import com.jgb.formacionATSistemas.model.Answer;
import com.jgb.formacionATSistemas.model.AnswerUser;
import com.jgb.formacionATSistemas.model.Course;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.User;
import com.jgb.formacionATSistemas.service.AnswerService;
import com.jgb.formacionATSistemas.service.AnswerUserService;
import com.jgb.formacionATSistemas.service.CourseService;
import com.jgb.formacionATSistemas.service.QuestionService;
import com.jgb.formacionATSistemas.service.QuizService;

@Service
public class CourseServiceImp implements CourseService {

	/**
	 * @Author = Javier Gallardo
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	CourseDAO courseDao;
	
	@Autowired
	QuizService quizService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	AnswerUserService answerUserService;
	
	@Autowired
	AnswerService answerService;

	@Override
	public Course create(Course course)
	{
		return courseDao.save(course);
	}

	@Override
	public void update(Course course)
	{
		courseDao.save(course);
	}

	@Override
	public Optional<Course> findById(Integer id)
	{
		return courseDao.findById(id);
	}

	@Override
	public List<Course> findAll(Pageable p) {
		return courseDao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Course course) {
		courseDao.delete(course);
	}

	@Override
	public List<User> findUserById(Integer courseId) {
		Optional<Course> course = findById(courseId);
		return course.get().getUser();
	}
	
	public List<Quiz> findQuizById(Integer courseId)
	{
		Optional<Course> course = findById(courseId);
		return course.get().getQuiz();
	}

	@Override
	public Optional<Quiz> findQuizByIdQuiz(Integer idQuiz) {
		return quizService.findById(idQuiz);
	}

	@Override
	public AnswerUser create(AnswerUser answerUser) {
		return answerUserService.create(answerUser);
	}

	@Override
	public Optional<Answer> findAnswerByOkAndQuestion(Question question) {
		return answerService.findByOkisTrueAndQuestion(question);
	}
}
