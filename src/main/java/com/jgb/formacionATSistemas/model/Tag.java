package com.jgb.formacionATSistemas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tag {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTag;
	
	@Column(nullable = false, unique = true)
	private String tag;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = Quiz.FIELD_TAG)
	private List<Quiz> quiz;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Question.FIELD_TAG)
	private List<Question> question;
}
