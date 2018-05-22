package com.jgb.formacionATSistemas.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jgb.formacionATSistema.dto.UserDTO;
import com.jgb.formacionATSistema.dto.UserPostDTO;
import com.jgb.formacionATSistemas.component.UserMapper;
import com.jgb.formacionATSistemas.model.User;

import com.jgb.formacionATSistemas.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public Set<UserDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<User> users = userService.findAll(PageRequest.of(page, size));
		return userMapper.modelToDto(users);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public UserDTO create(@RequestBody UserPostDTO dto) {
		final User user = userMapper.dtoToModel(dto);
		final User createUser = userService.create(user);
		return userMapper.modelToDto(createUser);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody UserPostDTO dto) {
		final User user = userMapper.dtoToModel(dto);
		userService.create(user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestBody UserDTO dto) {
		final User user = userMapper.dtoToModel(dto);
		userService.delete(user);
	}
}
