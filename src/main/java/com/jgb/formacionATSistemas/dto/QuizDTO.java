package com.jgb.formacionATSistemas.dto;

import java.util.List;

import lombok.Data;

@Data
public class QuizDTO {
	
	Integer idQuiz;
	
	String quiz;
	
	Boolean rand; 
	
	Integer course;
	
	List<Integer> questions;
	
	List<Integer> tags;
}
