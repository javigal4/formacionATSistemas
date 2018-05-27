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
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
public class User {

	public static final String FIELD_COURSE = "course";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUser;

	@Column(nullable = false)
	private String name;

	@Column(unique = true, nullable = false)
	private String email;

	private String password;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = Result.FIELD_USER)
	private List<Result> result;
	
	@JoinColumn(name = FIELD_COURSE)
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Course> course;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = AnswerUser.FIELD_USER)
	private List<AnswerUser> answerUser;

}