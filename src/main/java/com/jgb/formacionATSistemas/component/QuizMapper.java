package com.jgb.formacionATSistemas.component;

import java.util.List;

import com.jgb.formacionATSistema.dto.QuizDTO;
import com.jgb.formacionATSistemas.model.Quiz;

public interface QuizMapper {

	Quiz dtoToModel(QuizDTO dto);

	QuizDTO modelToDto(Quiz quizzes);

	List<Quiz> dtoToModel(List<QuizDTO> dtos);

	List<QuizDTO> modelToDto(List<Quiz> models);
}
