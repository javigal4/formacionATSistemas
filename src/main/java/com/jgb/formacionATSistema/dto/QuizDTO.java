package com.jgb.formacionATSistema.dto;

import com.jgb.formacionATSistemas.model.Course;

import lombok.Data;

@Data
public class QuizDTO {
	
	Integer idQuiz;
	
	String quiz;
	
	Course course;
}
