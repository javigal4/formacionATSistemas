package com.jgb.formacionATSistemas.component;

import java.util.Set;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jgb.formacionATSistema.dto.UserDTO;
import com.jgb.formacionATSistemas.model.User;

@Component
public class UserMapperImp implements UserMapper{

	@Autowired
	public DozerBeanMapper dozer;
	
	@Override
	public User dtoToModel(UserDTO dto) {
		return dozer.map(dto, User.class);
	}

	@Override
	public UserDTO modelToDto(User model) {
		return dozer.map(model, UserDTO.class);
	}

	@Override
	public Set<User> dtoToModel(Set<UserDTO> users) {
		return users.stream().map(d -> dtoToModel(d)).collect(Collectors.toSet());
	}

	@Override
	public Set<UserDTO> modelToDto(Set<User> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toSet());
	}

}
