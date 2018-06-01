package com.jgb.formacionATSistemas.component;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jgb.formacionATSistema.dto.TagDTO;
import com.jgb.formacionATSistemas.model.Tag;

@Component
public class TagMapperImp implements TagMapper{

	@Autowired
	public DozerBeanMapper dozer;

	@Override
	public Tag dtoToModel(TagDTO dto) {
		return dozer.map(dto, Tag.class);
	}

	@Override
	public TagDTO modelToDto(Tag model) {
		return dozer.map(model, TagDTO.class);
	}

	@Override
	public List<Tag> dtoToModel(List<TagDTO> dtos) {
		return dtos.stream().map(a -> dtoToModel(a)).collect(Collectors.toList());
	}

	@Override
	public List<TagDTO> modelToDto(List<Tag> models) {
		return models.stream().map(a -> modelToDto(a)).collect(Collectors.toList());
	}
	

}
