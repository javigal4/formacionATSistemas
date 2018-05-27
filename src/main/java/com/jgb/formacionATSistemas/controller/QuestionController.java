package com.jgb.formacionATSistemas.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jgb.formacionATSistema.dto.QuestionDTO;
import com.jgb.formacionATSistemas.component.QuestionMapper;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Tag;
import com.jgb.formacionATSistemas.service.QuestionService;

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
		return questionMapper.modelToDto(question);
	}
/*
	@RequestMapping(method = RequestMethod.POST)
	public QuestionDTO create(@RequestBody QuestionDTO dto)
	{
		final Optional<Tag> tag = questionService.findTagById(dto.getTag().getIdTag());
		final Question question = questionMapper.dtoToModel(dto);
		question.setTag(tag.get());
		
		final Question createQuestion = questionService.create(question);
		return questionMapper.modelToDto(createQuestion);
	}
*/	
}
