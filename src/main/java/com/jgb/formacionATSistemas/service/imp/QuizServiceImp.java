package com.jgb.formacionATSistemas.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jgb.formacionATSistemas.dao.QuizDAO;
import com.jgb.formacionATSistemas.model.Course;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.Tag;
import com.jgb.formacionATSistemas.service.CourseService;
import com.jgb.formacionATSistemas.service.QuestionService;
import com.jgb.formacionATSistemas.service.QuizService;
import com.jgb.formacionATSistemas.service.TagService;

@Service
public class QuizServiceImp implements QuizService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1623193298633934858L;

	@Autowired
	QuizDAO quizDao;
	
	@Autowired
	QuestionService questionService;

	@Autowired
	TagService tagService;

	@Autowired
	CourseService courseService;
	
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
	
	public List<Tag> findTagByQuiz(Quiz quiz)
	{
		return tagService.findByQuiz(quiz);
	}

	@Override
	public Optional<Course> findCourseByIdCourse(Integer idCourse)
	{
		return courseService.findById(idCourse);
	}

}
