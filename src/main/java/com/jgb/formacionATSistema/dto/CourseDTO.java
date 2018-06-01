package com.jgb.formacionATSistema.dto;

import java.util.List;

import lombok.Data;

@Data
public class CourseDTO {

	Integer idCourse;
	
	String course;
	
	List<Integer> users;
	
	List<Integer> quiz;

}
