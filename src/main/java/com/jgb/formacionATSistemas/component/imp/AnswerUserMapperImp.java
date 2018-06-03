package com.jgb.formacionATSistemas.component.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jgb.formacionATSistemas.component.AnswerUserMapper;
import com.jgb.formacionATSistemas.dto.AnswerUserDTO;
import com.jgb.formacionATSistemas.model.AnswerUser;

@Component
public class AnswerUserMapperImp implements AnswerUserMapper {

	@Autowired
	public DozerBeanMapper dozer;
	

	@Override
	public AnswerUser dtoToModel(AnswerUserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnswerUserDTO modelToDto(AnswerUser model) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<AnswerUser> dtoToModel(List<AnswerUserDTO> dtos) {
		return dtos.stream().map(d -> dtoToModel(d)).collect(Collectors.toList());
	}

	@Override
	public List<AnswerUserDTO> modelToDto(List<AnswerUser> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toList());
	}
}
