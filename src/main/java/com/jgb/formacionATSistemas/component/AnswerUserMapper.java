package com.jgb.formacionATSistemas.component;

import java.util.List;

import com.jgb.formacionATSistemas.dto.AnswerUserDTO;
import com.jgb.formacionATSistemas.model.AnswerUser;

public interface AnswerUserMapper {
	
	AnswerUser dtoToModel(AnswerUserDTO dto);

	AnswerUserDTO modelToDto(AnswerUser model);

	List<AnswerUser> dtoToModel(List<AnswerUserDTO> dtos);

	List<AnswerUserDTO> modelToDto(List<AnswerUser> models);
}
