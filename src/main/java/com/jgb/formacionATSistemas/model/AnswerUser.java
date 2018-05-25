package com.jgb.formacionATSistemas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class AnswerUser {
	
	public static final String FIELD_USER = "user";
	public static final String FIELD_QUESTION = "question";
	
	@Id
	@GeneratedValue
	private Integer idAnswerUser;
	
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Quiz.FIELD_ANSWER_USER)
	private List<Quiz> quiz;
	
	@JoinColumn(name = FIELD_USER)
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@JoinColumn(name = FIELD_QUESTION)
	@ManyToOne(fetch = FetchType.LAZY)
	private Question question;
}
