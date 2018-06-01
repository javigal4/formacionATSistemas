package com.jgb.formacionATSistemas.component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jgb.formacionATSistema.dto.AnswerDTO;
import com.jgb.formacionATSistema.dto.QuestionDTO;
import com.jgb.formacionATSistema.dto.TagDTO;
import com.jgb.formacionATSistemas.model.Answer;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Tag;
import com.jgb.formacionATSistemas.service.AnswerService;
import com.jgb.formacionATSistemas.service.QuestionService;

import lombok.extern.java.Log;

@Log
@Component
public class QuestionMapperImp implements QuestionMapper{

	@Autowired
	public DozerBeanMapper dozer;
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	AnswerMapper answerMapper;
	
	@Autowired
	TagMapper tagMapper;
	
	@Override
	public Question dtoToModel(QuestionDTO dto) {
		log.info("Map Question: DTO to model");
		Optional<Question> question = questionService.findById(dto.getIdQuestion());
		
		log.info("hola " + question.get().getTag());
		
		List<Optional<Answer>> answersOpt = dto.getAnswers().stream().map(a -> answerService.findById(a)).collect(Collectors.toList());
		
		List<Answer> answers = answersOpt.stream().map(Optional::get).collect(Collectors.toList());
		question.get().setAnswer(answers);
		return question.get();
	}

	@Override
	public QuestionDTO modelToDto(Question model)
	{
		log.info("Map Question: model to DTO");
		Tag tag = questionService.findTagById(model.getIdQuestion());
		TagDTO tagDTO = tagMapper.modelToDto(tag);
		Integer tagInt = tagDTO.getIdTag();
		List<Answer> answers = questionService.findAnswerById(model.getIdQuestion());
		
		List<AnswerDTO> answersDTO = answerMapper.modelToDto(answers);
		List<Integer> answersInt = answersDTO.stream().map(a -> a.getIdAnswer()).collect(Collectors.toList());
		
		QuestionDTO questionDTO = dozer.map(model, QuestionDTO.class);
		questionDTO.setAnswers(answersInt);
		questionDTO.setTagId(tagInt);
		return questionDTO;
	}

	@Override
	public List<Question> dtoToModel(List<QuestionDTO> dtos) {
		return dtos.stream().map(d -> dtoToModel(d)).collect(Collectors.toList());
	}

	@Override
	public List<QuestionDTO> modelToDto(List<Question> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toList());
	}
}
