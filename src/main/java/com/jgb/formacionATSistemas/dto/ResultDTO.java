package com.jgb.formacionATSistemas.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ResultDTO {
	
	Integer idResult;
	
	Date date;
	
	Double result;
	
	Integer idUser;
	
	Integer idQuiz;
}
