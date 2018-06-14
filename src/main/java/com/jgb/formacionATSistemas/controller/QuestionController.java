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

import com.jgb.formacionATSistemas.component.AnswerMapper;
import com.jgb.formacionATSistemas.component.QuestionMapper;
import com.jgb.formacionATSistemas.dto.AnswerDTO;
import com.jgb.formacionATSistemas.dto.QuestionDTO;
import com.jgb.formacionATSistemas.exception.NotFoundException;
import com.jgb.formacionATSistemas.model.Answer;
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
	
	@Autowired
	AnswerMapper answerMapper;
	
	//-------------------Find all questions--------------------------------------------------------
	@RequestMapping(method = RequestMethod.GET)
	public List<QuestionDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size)
	{
		final List<Question> question = questionService.findAll(PageRequest.of(page, size));
		log.info("Obteniendo datos de todos las preguntas");
		return questionMapper.modelToDto(question);
	}
	
	//-------------------Find one question--------------------------------------------------------
	@RequestMapping(method = RequestMethod.GET, value = "/{idQuestion}")
	public QuestionDTO findById(@PathVariable Integer idQuestion) throws NotFoundException
	{
		Optional<Question> question = questionService.findById(idQuestion);
		log.info("Obteniendo datos de la pregunta " +idQuestion);
		if (!question.isPresent())
			throw new NotFoundException();
		else
			return questionMapper.modelToDto(question.get());
	}
	
	
	//-------------------Create a question--------------------------------------------------------

	@RequestMapping(method = RequestMethod.POST)
	public QuestionDTO create(@RequestBody QuestionDTO dto)
	{
		log.info("Creando una pregunta");
		final Question createQuestion = questionMapper.dtoToModel(dto);
		questionService.create(createQuestion);
		return questionMapper.modelToDto(createQuestion);
	}

	
	
	//-------------------Create an answer to a question--------------------------------------------------------
	
	@RequestMapping(method = RequestMethod.POST, value = "/{idQuestion}/answer")
	public AnswerDTO createAnswer(@PathVariable("idQuestion") Integer idQuestion , @RequestBody AnswerDTO dto)
	{
		log.info("Creando respuesta a la pregunta con id: " + idQuestion);
		Answer answer = answerMapper.dtoToModel(dto);
		Optional<Question> question = questionService.findById(idQuestion);
		answer.setQuestion(question.get());
		return answerMapper.modelToDto(questionService.createAnswer(answer));
	}
	
	
	//-------------------Update question--------------------------------------------------------
	
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
