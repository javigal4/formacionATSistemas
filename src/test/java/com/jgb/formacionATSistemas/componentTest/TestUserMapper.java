package com.jgb.formacionATSistemas.componentTest;

import java.util.Set;

import com.jgb.formacionATSistemas.dto.UserDTO;
import com.jgb.formacionATSistemas.model.User;

public interface TestUserMapper {
	
	void testDtoToModel();

	UserDTO testModelToDto(User model);

	Set<User> testDtoToModel(Set<UserDTO> users);

	Set<UserDTO> testModelToDto(Set<User> models);
}