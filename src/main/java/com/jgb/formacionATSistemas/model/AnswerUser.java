package com.jgb.formacionATSistemas.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class AnswerUser {
	
	public static final String FIELD_USER = "user";
	public static final String FIELD_QUESTION = "question";
	public static final String FIELD_QUIZ = "quiz";
	
	@Id
	@GeneratedValue
	private Integer idAnswerUser;
	
	@JoinColumn(name = FIELD_QUIZ)
	@ManyToOne(fetch = FetchType.LAZY)
	private Quiz quiz;
	
	@JoinColumn(name = FIELD_USER)
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@JoinColumn(name = FIELD_QUESTION)
	@ManyToOne(fetch = FetchType.LAZY)
	private Question question;
	
	private Boolean ok;
	
	private String answer;
}
