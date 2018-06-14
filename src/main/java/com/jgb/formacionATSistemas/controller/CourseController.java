package com.jgb.formacionATSistemas.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jgb.formacionATSistemas.component.AnswerMapper;
import com.jgb.formacionATSistemas.component.AnswerUserMapper;
import com.jgb.formacionATSistemas.component.CourseMapper;
import com.jgb.formacionATSistemas.component.QuizMapper;
import com.jgb.formacionATSistemas.dto.AnswerUserDTO;
import com.jgb.formacionATSistemas.dto.CourseDTO;
import com.jgb.formacionATSistemas.dto.QuizDTO;
import com.jgb.formacionATSistemas.exception.NotFoundException;
import com.jgb.formacionATSistemas.model.Answer;
import com.jgb.formacionATSistemas.model.AnswerUser;
import com.jgb.formacionATSistemas.model.Course;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.service.AnswerUserService;
import com.jgb.formacionATSistemas.service.CourseService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping(value = "/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	AnswerUserService answerUserService;
	
	@Autowired
	CourseMapper courseMapper;
	
	@Autowired
	AnswerMapper answerMapper;
	
	@Autowired
	QuizMapper quizMapper;
	
	@Autowired
	AnswerUserMapper answerUserMapper;
	
	//-------------------Find all courses--------------------------------------------------------
	@RequestMapping(method = RequestMethod.GET)
	public List<CourseDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size)
	{
		final List<Course> course = courseService.findAll(PageRequest.of(page, size));
		log.info("Obteniendo datos de todos los cursos");
		return courseMapper.modelToDto(course);
	}
	
	//-------------------Find one course--------------------------------------------------------
	@RequestMapping(method = RequestMethod.GET, value = "/{idCourse}")
	public CourseDTO findById(@PathVariable Integer idCourse) throws NotFoundException
	{
		Optional<Course> course = courseService.findById(idCourse);
		log.info("Obteniendo datos del curso " +idCourse);
		if (!course.isPresent())
			throw new NotFoundException();
		else
			return courseMapper.modelToDto(course.get());
	}
	
	
	//-------------------Find quizzes to one course--------------------------------------------------------
	@GetMapping("/{idCourse}/quiz")
	public List<QuizDTO> findQuizByCourse(@PathVariable("idCourse") Integer idCourse)
	{
		log.info("Obteniendo datos de los cuestionarios de un curso ");
		Optional<Course> course = courseService.findById(idCourse);
		List<Quiz> quiz = courseService.findQuizById(course.get().getIdCourse());
		
		//Desordenar las preguntas
		Collections.shuffle(quiz);
		return quizMapper.modelToDto(quiz);
	}
	
	
	//-------------------Create an user's answer--------------------------------------------------------
		@PostMapping("/{idCourse}/quiz/{idQuiz}/answerUser")
		public AnswerUserDTO createAnswerUser(@PathVariable("idCourse") Integer idCourse, @PathVariable("idQuiz") Integer idQuiz,
				@RequestBody AnswerUserDTO dto)
		{
			log.info("Creando respuesta de un usuario a una pregunta de un cuestionario de un curso");
			AnswerUser answerUser = answerUserMapper.dtoToModel(dto);
			
			Optional<Quiz> quizOpt = courseService.findQuizByIdQuiz(idQuiz);
			if (quizOpt.isPresent())
				answerUser.setQuiz(quizOpt.get());
			
			//Si la respuesta es igual a la respuesta de la pregunta con ok = true, la ponemos a true
			Optional<Answer> answer = courseService.findAnswerByOkAndQuestion(answerUser.getQuestion());
			if (answer.isPresent())
			{
				if (answerUser.getAnswer().equals(answer.get().getAnswer()))
					answerUser.setOk(true);
				else
					answerUser.setOk(false);
			}
			else
				answerUser.setOk(false);

			courseService.create(answerUser);
			return answerUserMapper.modelToDto(answerUser);
		}
	
	
	//-------------------Create a course--------------------------------------------------------

	@RequestMapping(method = RequestMethod.POST)
	public CourseDTO create(@RequestBody CourseDTO dto)
	{
		log.info("Creando un curso");
		final Course createCourse = courseMapper.dtoToModel(dto);
		courseService.create(createCourse);
		return courseMapper.modelToDto(createCourse);
	}

	
	//-------------------Update course--------------------------------------------------------
	
	@RequestMapping(method = RequestMethod.POST, value = "/{idCourse}")
	public void update(@PathVariable("idCourse") Integer idCourse, @RequestBody CourseDTO dto) throws NotFoundException
	{
		log.info("Actualizando el curso " + idCourse);
		
		Optional<Course> courseFind = courseService.findById(idCourse);
		if (courseFind.isPresent())	
		{
			Course course = courseMapper.dtoToModel(dto);
			course.setIdCourse(idCourse);
			courseService.update(course);
		}
		else
			throw new NotFoundException();
	}
	
	
	//-------------------Delete course--------------------------------------------------------
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idCourse}")
	public void delete(@PathVariable("idCourse") Integer idCourse) throws NotFoundException
	{
		log.info("Eliminando curso " + idCourse);
		
		Optional<Course> course = courseService.findById(idCourse);
		if (course.isPresent())
			courseService.delete(course.get());
		else
			throw new NotFoundException();
	}

}
