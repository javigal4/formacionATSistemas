package com.jgb.formacionATSistemas.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jgb.formacionATSistemas.component.QuestionMapper;
import com.jgb.formacionATSistemas.component.QuizMapper;
import com.jgb.formacionATSistemas.dto.QuestionDTO;
import com.jgb.formacionATSistemas.dto.QuizDTO;
import com.jgb.formacionATSistemas.exception.NotFoundException;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.service.QuizService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping(value = "/quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@Autowired
	QuizMapper quizMapper;
	
	@Autowired
	QuestionMapper questionMapper;
	
	//-------------------Find all quizzes--------------------------------------------------------	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<QuizDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size)
	{
		log.info("Obteniendo datos de todos los cuestionarios");
		final List<Quiz> quiz = quizService.findAll(PageRequest.of(page, size));
		return quizMapper.modelToDto(quiz);
	}
	
	//-------------------Find one quiz--------------------------------------------------------
	
	@GetMapping("/{idQuiz}")
	public QuizDTO findById(@PathVariable("idQuiz") Integer idQuiz)
	{
		log.info("Obteniendo datos de un cuestionario");
		final Optional<Quiz> quiz = quizService.findById(idQuiz);
		return quizMapper.modelToDto(quiz.get());
	}
	
	//-------------------Find questions in one quiz--------------------------------------------------------
	
	@GetMapping("/{idQuiz}/question")
	public List<QuestionDTO> findQuestionByQuiz(@PathVariable("idQuiz") Integer idQuiz)
	{
		log.info("Obteniendo las preguntas de un cuestionario");
		Optional<Quiz> quiz = quizService.findById(idQuiz);
		List<Question> questions = quizService.findQuestionByQuiz(quiz.get());
		
		//Desordenar las preguntas
		Collections.shuffle(questions);
		return questionMapper.modelToDto(questions);
	}
	
	
	//-------------------Create a quiz--------------------------------------------------------
	
	@RequestMapping(method = RequestMethod.POST)
	public QuizDTO create(@RequestBody QuizDTO dto)
	{
		log.info("Creando un cuestionario");
		final Quiz quiz = quizMapper.dtoToModel(dto);
		final Quiz createQuiz = quizService.create(quiz);
		return quizMapper.modelToDto(createQuiz);
	}
	
	//-------------------Update a quiz--------------------------------------------------------
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody QuizDTO dto) throws NotFoundException
	{
		log.info("Actualizando un cuestionario");
		
		Optional<Quiz> quizFind = quizService.findById(dto.getIdQuiz());
		if (quizFind.isPresent())	
		{
			Quiz quiz = quizMapper.dtoToModel(dto);
			quizService.update(quiz);
		}
		else
			throw new NotFoundException();
	}
	
	//-------------------Delete a quiz--------------------------------------------------------
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idQuiz}")
	public void delete(@PathVariable("idQuiz") Integer idQuiz) throws NotFoundException
	{
		log.info("Eliminando cuestionario " + idQuiz);
		
		Optional<Quiz> quiz = quizService.findById(idQuiz);
		if (quiz.isPresent())
			quizService.delete(quiz.get());
		else
			throw new NotFoundException();
	}
}
