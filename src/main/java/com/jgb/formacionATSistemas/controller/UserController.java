package com.jgb.formacionATSistemas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jgb.formacionATSistemas.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
}
