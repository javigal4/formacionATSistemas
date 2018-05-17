package com.jgb.formacionATSistemas.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
	
	public static final String FIELD_QUESTION = "question";
	
	@Id
	@GeneratedValue
	private Integer idAnswer;
	
	private String name;
	
	@JoinColumn(name = FIELD_QUESTION)
	@ManyToOne(fetch = FetchType.LAZY)
	private Question question;
}
