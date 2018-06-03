package com.jgb.formacionATSistemas.component;

import java.util.List;

import com.jgb.formacionATSistemas.dto.TagDTO;
import com.jgb.formacionATSistemas.model.Tag;

public interface TagMapper {
	
	Tag dtoToModel(TagDTO dto);

	TagDTO modelToDto(Tag model);

	List<Tag> dtoToModel(List<TagDTO> dtos);

	List<TagDTO> modelToDto(List<Tag> models);
}
