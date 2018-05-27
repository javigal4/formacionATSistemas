package com.jgb.formacionATSistemas.exception;

public class AnswerException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String MSG = "Ya hay una respuesta verdadera";
	
	public AnswerException() {
		super(MSG);
	}
}
