package com.jgb.formacionATSistemas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Difficulty {

	public static final String FIELD_QUESTION = "question";
	
	@Id
	@GeneratedValue
	private Integer idDifficulty;
	
	@Column(nullable = false)
	private String difficulty;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Question.FIELD_DIFFICULTY)
	private List<Question> question;
}
