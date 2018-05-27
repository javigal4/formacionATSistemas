package com.jgb.formacionATSistemas.component;

import java.util.Set;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jgb.formacionATSistema.dto.QuestionDTO;
import com.jgb.formacionATSistemas.model.Question;

@Component
public class QuestionMapperImp implements QuestionMapper{

	@Autowired
	public DozerBeanMapper dozer;
	
	@Override
	public Question dtoToModel(QuestionDTO dto) {
		return dozer.map(dto, Question.class);
	}

	@Override
	public QuestionDTO modelToDto(Question model) {
		return dozer.map(model, QuestionDTO.class);
	}

	@Override
	public Set<Question> dtoToModel(Set<QuestionDTO> dtos) {
		return dtos.stream().map(d -> dtoToModel(d)).collect(Collectors.toSet());
	}

	@Override
	public Set<QuestionDTO> modelToDto(Set<Question> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toSet());
	}
}
