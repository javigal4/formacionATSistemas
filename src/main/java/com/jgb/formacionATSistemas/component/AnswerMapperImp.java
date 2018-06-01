package com.jgb.formacionATSistemas.component;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jgb.formacionATSistema.dto.AnswerDTO;
import com.jgb.formacionATSistemas.model.Answer;

@Component
public class AnswerMapperImp implements AnswerMapper{

	@Autowired
	public DozerBeanMapper dozer;

	@Override
	public Answer dtoToModel(AnswerDTO dto) {
		return dozer.map(dto, Answer.class);
	}

	@Override
	public AnswerDTO modelToDto(Answer model) {
		return dozer.map(model, AnswerDTO.class);
	}

	@Override
	public List<Answer> dtoToModel(List<AnswerDTO> dtos) {
		return dtos.stream().map(a -> dtoToModel(a)).collect(Collectors.toList());
	}

	@Override
	public List<AnswerDTO> modelToDto(List<Answer> models) {
		return models.stream().map(a -> modelToDto(a)).collect(Collectors.toList());
	}
	

}
