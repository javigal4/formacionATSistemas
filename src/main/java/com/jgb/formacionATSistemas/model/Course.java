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
public class Course {

	public static final String FIELD_USER = "user";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCourse;
	
	@Column(nullable = false, unique = true)
	private String course;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Quiz.FIELD_COURSE)
	private List<Quiz> quiz;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = User.FIELD_COURSE)
	List<User> user;
}
