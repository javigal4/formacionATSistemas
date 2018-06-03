package com.jgb.formacionATSistemas.dto;

import lombok.Data;

@Data
public class AnswerUserDTO {

	private Integer idAnswerUser;
	
	private String answer;
	
	private Boolean ok;
	
	private Integer idUser;
	
	private Integer IdQuestion;
	
	private Integer IdQuiz;
}
