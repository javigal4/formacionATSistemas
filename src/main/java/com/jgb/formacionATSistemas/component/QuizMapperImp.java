package com.jgb.formacionATSistemas.component;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jgb.formacionATSistema.dto.QuizDTO;
import com.jgb.formacionATSistemas.model.Quiz;

@Component
public class QuizMapperImp implements QuizMapper{

	@Autowired
	public DozerBeanMapper dozer;
	
	@Override
	public Quiz dtoToModel(QuizDTO dto) {
		return dozer.map(dto, Quiz.class);
	}

	@Override
	public QuizDTO modelToDto(Quiz model) {
		return dozer.map(model, QuizDTO.class);
	}

	@Override
	public List<Quiz> dtoToModel(List<QuizDTO> dtos) {
		return dtos.stream().map(d -> dtoToModel(d)).collect(Collectors.toList());
	}

	@Override
	public List<QuizDTO> modelToDto(List<Quiz> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toList());
	}
}
