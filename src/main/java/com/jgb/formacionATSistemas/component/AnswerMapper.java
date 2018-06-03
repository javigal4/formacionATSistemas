package com.jgb.formacionATSistemas.component;

import java.util.List;

import com.jgb.formacionATSistemas.dto.AnswerDTO;
import com.jgb.formacionATSistemas.dto.AnswerGetDTO;
import com.jgb.formacionATSistemas.model.Answer;

public interface AnswerMapper {
	
	Answer dtoToModel(AnswerDTO dto);

	AnswerDTO modelToDto(Answer model);
	
	AnswerGetDTO modelToDto1(Answer model);

	List<Answer> dtoToModel(List<AnswerDTO> dtos);

	List<AnswerDTO> modelToDto(List<Answer> models);
	
	List<AnswerGetDTO> modelToDto1(List<Answer> model);
}
