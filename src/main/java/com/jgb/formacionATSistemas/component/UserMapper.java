package com.jgb.formacionATSistemas.component;

import java.util.List;

import com.jgb.formacionATSistemas.dto.UserDTO;
import com.jgb.formacionATSistemas.model.User;

public interface UserMapper {
	
	User dtoToModel(UserDTO dto);

	UserDTO modelToDto(User user);

	List<User> dtoToModel(List<UserDTO> users);

	List<UserDTO> modelToDto(List<User> models);
}