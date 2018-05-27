package com.jgb.formacionATSistemas.component;

import java.util.Set;

import com.jgb.formacionATSistema.dto.QuestionDTO;
import com.jgb.formacionATSistemas.model.Question;

public interface QuestionMapper {
	
	Question dtoToModel(QuestionDTO dto);

	QuestionDTO modelToDto(Question model);

	Set<Question> dtoToModel(Set<QuestionDTO> dtos);

	Set<QuestionDTO> modelToDto(Set<Question> models);
}
