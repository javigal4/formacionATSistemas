package com.jgb.formacionATSistemas.component;

import java.util.Set;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jgb.formacionATSistema.dto.QuizDTO;
import com.jgb.formacionATSistema.dto.UserDTO;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.User;

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
	public Set<Quiz> dtoToModel(Set<QuizDTO> dtos) {
		return dtos.stream().map(d -> dtoToModel(d)).collect(Collectors.toSet());
	}

	@Override
	public Set<QuizDTO> modelToDto(Set<Quiz> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toSet());
	}
}
