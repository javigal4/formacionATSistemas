package com.jgb.formacionATSistema.dto;

import java.util.List;

import lombok.Data;

@Data
public class QuestionDTO {

	Integer idQuestion;
	
	String question;
	
	Integer tagId;
	
	List<Integer> answers;

	//List<Integer> answerUsers;
}
