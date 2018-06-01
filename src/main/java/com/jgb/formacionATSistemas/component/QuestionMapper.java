package com.jgb.formacionATSistemas.component;

import java.util.List;

import com.jgb.formacionATSistema.dto.QuestionDTO;
import com.jgb.formacionATSistemas.model.Question;

public interface QuestionMapper {
	
	Question dtoToModel(QuestionDTO dto);

	QuestionDTO modelToDto(Question model);

	List<Question> dtoToModel(List<QuestionDTO> dtos);

	List<QuestionDTO> modelToDto(List<Question> models);
}
