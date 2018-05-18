package com.jgb.formacionATSistemas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Integer idTag;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = Quiz.FIELD_TAG)
	private List<Quiz> quiz;
}
