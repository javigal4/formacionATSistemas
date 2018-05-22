package com.jgb.formacionATSistemas.component;

import java.util.Set;

import com.jgb.formacionATSistema.dto.UserDTO;
import com.jgb.formacionATSistemas.model.User;

public interface UserMapper {
	
	User dtoToModel(UserDTO dto);

	UserDTO modelToDto(User model);

	Set<User> dtoToModel(Set<UserDTO> users);

	Set<UserDTO> modelToDto(Set<User> models);
}