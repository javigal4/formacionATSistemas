package com.jgb.formacionATSistemas.component;

import java.util.List;

import com.jgb.formacionATSistema.dto.AnswerDTO;
import com.jgb.formacionATSistemas.model.Answer;

public interface AnswerMapper {
	
	Answer dtoToModel(AnswerDTO dto);

	AnswerDTO modelToDto(Answer model);

	List<Answer> dtoToModel(List<AnswerDTO> dtos);

	List<AnswerDTO> modelToDto(List<Answer> models);
}
