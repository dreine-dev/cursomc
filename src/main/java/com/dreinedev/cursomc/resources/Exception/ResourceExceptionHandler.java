package com.dreinedev.cursomc.resources.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.dreinedev.cursomc.services.exceptions.ObjectNotFoundExcepeion;

import jakarta.servlet.http.HttpServletRequest;

@EnableWebMvc
@ControllerAdvice
public class ResourceExceptionHandler{

	@ExceptionHandler(ObjectNotFoundExcepeion.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExcepeion e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	
	
}
