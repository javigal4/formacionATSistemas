package com.jgb.formacionATSistemas.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jgb.formacionATSistema.dto.QuizDTO;
import com.jgb.formacionATSistemas.component.QuizMapper;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.service.QuizService;

@RestController
@RequestMapping(value = "/quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@Autowired
	QuizMapper quizMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public Set<QuizDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size)
	{
		final Set<Quiz> quiz = quizService.findAll(PageRequest.of(page, size));
		return quizMapper.modelToDto(quiz);
	}

	@RequestMapping(method = RequestMethod.POST)
	public QuizDTO create(@RequestBody QuizDTO dto)
	{
		final Quiz quiz = quizMapper.dtoToModel(dto);
		final Quiz createQuiz = quizService.create(quiz);
		return quizMapper.modelToDto(createQuiz);
	}
}
