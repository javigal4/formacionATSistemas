package com.jgb.formacionATSistemas.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jgb.formacionATSistema.dto.QuestionDTO;
import com.jgb.formacionATSistemas.component.QuestionMapper;
import com.jgb.formacionATSistemas.exception.NotFoundException;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.service.QuestionService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping(value = "/question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@Autowired
	QuestionMapper questionMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public Set<QuestionDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size)
	{
		final Set<Question> question = questionService.findAll(PageRequest.of(page, size));
		log.info("Obteniendo datos de todos las preguntas");
		return questionMapper.modelToDto(question);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idQuestion}")
	public QuestionDTO findById(@PathVariable Integer idQuestion) throws NotFoundException
	{
		Optional<Question> question = questionService.findById(idQuestion);
		if (!question.isPresent())
			throw new NotFoundException();
		else
			return questionMapper.modelToDto(question.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public QuestionDTO create(@RequestBody QuestionDTO dto)
	{
		log.info("Creando una pregunta");
		final Question createQuestion = questionMapper.dtoToModel(dto);
		return questionMapper.modelToDto(questionService.create(createQuestion));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/{idQuestion}")
	public void update(@PathVariable("idQuestion") Integer idQuestion, @RequestBody QuestionDTO dto) throws NotFoundException
	{
		log.info("Actualizando la pregunta " + idQuestion);
		Question question = questionMapper.dtoToModel(dto);
		questionService.update(question);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idQuestion}")
	public void delete(@PathVariable("idQuestion") Integer idQuestion)
	{
		log.info("Eliminando pregunta " + idQuestion + " y todas sus respuestas");
		questionService.delete(questionService.findById(idQuestion).get());
	}
	

}
