package com.jgb.formacionATSistemas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Result {

	public static final String FIELD_USER = "user";
	public static final String FIELD_QUIZ = "quiz";
	
	@Id
	@GeneratedValue
	private Integer idResult;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@JoinColumn(name = FIELD_USER)
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@JoinColumn(name = FIELD_QUIZ)
	@ManyToOne(fetch = FetchType.LAZY)
	private Quiz quiz;

}