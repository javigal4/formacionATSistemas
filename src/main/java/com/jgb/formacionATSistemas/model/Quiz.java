package com.jgb.formacionATSistemas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Quiz {
	
	public static final String FIELD_COURSE = "course";
	public static final String FIELD_TAG = "tag";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idQuiz;
	
	@Column(nullable = false, unique = true)
	private String quiz;
	
	@JoinColumn(name = FIELD_COURSE)
	@ManyToOne(fetch = FetchType.LAZY)
	private Course course;
	
	@JoinColumn(name = FIELD_TAG)
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Tag> tag;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = Question.FIELD_QUIZ)
	List<Question> question;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = AnswerUser.FIELD_QUIZ)
	private List<AnswerUser> answerUser;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Result.FIELD_QUIZ)
	private List<Result> result;
	
}
