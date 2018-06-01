package com.jgb.formacionATSistemas.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jgb.formacionATSistema.dto.UserDTO;
import com.jgb.formacionATSistema.dto.UserPostDTO;
import com.jgb.formacionATSistemas.component.UserMapper;
import com.jgb.formacionATSistemas.exception.NotFoundException;
import com.jgb.formacionATSistemas.model.User;
import com.jgb.formacionATSistemas.service.UserService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<UserDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size)
	{
		final List<User> users = userService.findAll(PageRequest.of(page, size));
		log.info("Obteniendo datos de todos los usuarios");
		return userMapper.modelToDto(users);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idUser}")
	public UserDTO findById(@PathVariable Integer idUser) throws NotFoundException
	{
		log.info("Obteniendo datos del usuario " + idUser);
		Optional<User> user = userService.findById(idUser);
		if (!user.isPresent())
			//HACER EN SERVICE
			throw new NotFoundException();
		else
			return userMapper.modelToDto(user.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public UserDTO create(@RequestBody UserPostDTO dto)
	{
		final User user = userMapper.dtoToModel(dto);
		final User createUser = userService.create(user);
		log.info("Se ha añadido " + createUser.getName() + " al sistema");
		return userMapper.modelToDto(createUser);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/{idQuestion}")
	public void update(@PathVariable("idUser") Integer idUser, @RequestBody UserDTO dto) throws NotFoundException
	{
		log.info("Actualizando el usuario " + idUser);
		User user = userMapper.dtoToModel(dto);
		userService.update(user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idQuestion}")
	public void delete(@PathVariable("idUser") Integer idUser)
	{
		log.info("Eliminando usuario " + idUser);
		userService.delete(userService.findById(idUser).get());
	}
}
