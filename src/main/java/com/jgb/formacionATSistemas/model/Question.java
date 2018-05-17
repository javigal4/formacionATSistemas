package com.jgb.formacionATSistemas.model;

import java.util.List;

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

	public static final String FIELD_TAG = "tag";
	public static final String FIELD_QUESTIONARY = "questionary";
	
	@Id
	@GeneratedValue
	private Integer idQuestion;
	
	private String name;
	
	@JoinColumn(name = FIELD_TAG)
	@ManyToOne(fetch = FetchType.LAZY)
	private Tag tag;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Difficulty.FIELD_QUESTION)
	private List<Difficulty> difficulty;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Answer.FIELD_QUESTION)
	private List<Answer> answer;
	
	@JoinColumn(name = FIELD_QUESTIONARY)
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Questionary> questionary;
}
