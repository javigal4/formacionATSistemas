package com.jgb.formacionATSistemas.dto;

import java.util.List;

import lombok.Data;

@Data
public class QuestionDTO {

	Integer idQuestion;
	
	String question;
	
	Integer tagId;
	
	List<AnswerGetDTO> answers;

	//List<Integer> answerUsers;
}
