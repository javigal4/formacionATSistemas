package com.jgb.formacionATSistemas.dto;

import lombok.Data;

@Data
public class AnswerUserDTO {

	private Integer idAnswerUser;
	
	private String answer;
	
	private Integer idUser;
	
	private Integer idQuestion;
	
	private Integer idQuiz;
}
