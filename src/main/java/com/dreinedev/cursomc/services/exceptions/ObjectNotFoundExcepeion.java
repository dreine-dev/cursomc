package com.dreinedev.cursomc.services.exceptions;

public class ObjectNotFoundExcepeion extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundExcepeion(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundExcepeion(String msg, Throwable cause) {
		super(msg, cause);
	}

}
