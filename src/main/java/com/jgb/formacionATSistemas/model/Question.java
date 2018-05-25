package com.jgb.formacionATSistemas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {

	public static final String FIELD_QUIZ = "quiz";
	public static final String FIELD_TAG = "tag";
	
	@Id
	@GeneratedValue
	private Integer idQuestion;
	
	@Column(nullable = false)
	private String question;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Answer.FIELD_QUESTION)
	private List<Answer> answer;
	
	@JoinColumn(name = FIELD_QUIZ)
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Quiz> quiz;
	
	@JoinColumn(name = FIELD_TAG)
	@ManyToOne(fetch = FetchType.LAZY)
	Tag tag;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = AnswerUser.FIELD_QUESTION)
	List<AnswerUser> answerUser;
}
