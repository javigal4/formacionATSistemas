package com.jgb.formacionATSistemas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jgb.formacionATSistema.dto.CourseDTO;
import com.jgb.formacionATSistemas.component.AnswerMapper;
import com.jgb.formacionATSistemas.component.CourseMapper;
import com.jgb.formacionATSistemas.exception.NotFoundException;
import com.jgb.formacionATSistemas.model.Course;
import com.jgb.formacionATSistemas.service.CourseService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping(value = "/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	CourseMapper courseMapper;
	
	@Autowired
	AnswerMapper answerMapper;
	
	//-------------------Find all courses--------------------------------------------------------
	@RequestMapping(method = RequestMethod.GET)
	public List<CourseDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size)
	{
		final List<Course> course = courseService.findAll(PageRequest.of(page, size));
		log.info("Obteniendo datos de todos las preguntas");
		return courseMapper.modelToDto(course);
	}
	
	//-------------------Find one course--------------------------------------------------------
	@RequestMapping(method = RequestMethod.GET, value = "/{idCourse}")
	public CourseDTO findById(@PathVariable Integer idCourse) throws NotFoundException
	{
		Optional<Course> course = courseService.findById(idCourse);
		log.info("Obteniendo datos de la pregunta " +idCourse);
		if (!course.isPresent())
			throw new NotFoundException();
		else
			return courseMapper.modelToDto(course.get());
	}
	
	//-------------------Find courses by tag--------------------------------------------------------
	/*
	@RequestMapping(method = RequestMethod.GET, value="/{idCourse}/quiz/{idQuiz}")
	public List<CourseDTO> findByTag(@PathVariable Integer idCourse, @PathVariable Integer idQuiz)
	{
		
	}
	*/
	
	
	//-------------------Create a course--------------------------------------------------------

	@RequestMapping(method = RequestMethod.POST)
	public CourseDTO create(@RequestBody CourseDTO dto)
	{
		log.info("Creando una pregunta");
		final Course createCourse = courseMapper.dtoToModel(dto);
		System.out.println("HOLA " + createCourse.getCourse());
		courseService.create(createCourse);
		return courseMapper.modelToDto(createCourse);
	}

	
	
	//-------------------Create an answer to a course--------------------------------------------------------
	/*
	@RequestMapping(method = RequestMethod.POST, value = "/{idCourse}/answer")
	public AnswerDTO createAnswer(@PathVariable("idCourse") Integer idCourse , @RequestBody AnswerDTO dto)
	{
		log.info("Creando respuesta a la pregunta con id: " + idCourse);
		Answer answer = answerMapper.dtoToModel(dto);
		return answerMapper.modelToDto(courseService.createAnswer(answer));
	}
	
	
	//-------------------Update course--------------------------------------------------------
	
	@RequestMapping(method = RequestMethod.POST, value = "/{idCourse}")
	public void update(@PathVariable("idCourse") Integer idCourse, @RequestBody CourseDTO dto) throws NotFoundException
	{
		log.info("Actualizando la pregunta " + idCourse);
		Course course = courseMapper.dtoToModel(dto);
		courseService.update(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idCourse}")
	public void delete(@PathVariable("idCourse") Integer idCourse)
	{
		log.info("Eliminando pregunta " + idCourse + " y todas sus respuestas");
		courseService.delete(courseService.findById(idCourse).get());
	}
	*/

}
