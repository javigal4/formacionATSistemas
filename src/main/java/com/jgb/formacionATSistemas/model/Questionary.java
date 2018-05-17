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

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Questionary {
	
	public static final String FIELD_COURSE = "course";
	public static final String FIELD_TAG = "tag";
	
	@Id
	@GeneratedValue
	private Integer idQuestionary;
	
	@Column(nullable = false)
	private String name;
	
	@JoinColumn(name = FIELD_COURSE)
	@ManyToOne(fetch = FetchType.LAZY)
	private Course course;
	
	@JoinColumn(name = FIELD_TAG)
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Tag> tag;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = Question.FIELD_QUESTIONARY)
	List<Question> question;
	
}
