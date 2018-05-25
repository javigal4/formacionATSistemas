package com.jgb.formacionATSistemas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jgb.formacionATSistema.dto.ErrorDTO;
import com.jgb.formacionATSistemas.exception.NotFoundException;

@ResponseBody
@ControllerAdvice(basePackages = {"com.jgb.formacionATSistemas.controller.v1"})
public class ControllerAdviceV1 {

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDTO error(NotFoundException e) {
		return new ErrorDTO(e.getMessage());
	}
}
