package com.jgb.formacionATSistemas.component;

import java.util.List;

import com.jgb.formacionATSistema.dto.CourseDTO;
import com.jgb.formacionATSistemas.model.Course;

public interface CourseMapper {
	
	Course dtoToModel(CourseDTO dto);

	CourseDTO modelToDto(Course model);

	List<Course> dtoToModel(List<CourseDTO> dtos);

	List<CourseDTO> modelToDto(List<Course> models);
}
