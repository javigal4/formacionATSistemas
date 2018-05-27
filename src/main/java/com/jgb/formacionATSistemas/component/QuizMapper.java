package com.jgb.formacionATSistemas.component;

import java.util.Set;

import com.jgb.formacionATSistema.dto.QuizDTO;
import com.jgb.formacionATSistemas.model.Quiz;

public interface QuizMapper {

	Quiz dtoToModel(QuizDTO dto);

	QuizDTO modelToDto(Quiz model);

	Set<Quiz> dtoToModel(Set<QuizDTO> dtos);

	Set<QuizDTO> modelToDto(Set<Quiz> models);
}
