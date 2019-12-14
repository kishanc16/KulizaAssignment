package com.kuliza.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.kuliza.dto.ErrorDetailsDto;

/*
 * It is user defined exception Handler class 
 */

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	/*
	 * This method handle all type of  Exception
	 * */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorDetailsDto errorDetailsDto = new ErrorDetailsDto(new Date(), "Internal Server Error", ex.getLocalizedMessage());
		return new ResponseEntity<>(errorDetailsDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * This method handle with user not Exception, if user is not exist in database
	 * */
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
		ErrorDetailsDto errorDetailsDto = new ErrorDetailsDto(new Date(), "Record Not Found", ex.getMessage());
		return new ResponseEntity<>(errorDetailsDto, HttpStatus.NOT_FOUND);
	}

	/*
	 * This method valid dto argument and handle the exception , if argument is not valid as expected
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = null;
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			message = error.getDefaultMessage();
		}
		ErrorDetailsDto errorDetailsDto = new ErrorDetailsDto(new Date(), "Validation Failed",status+" : "+ message);
		return new ResponseEntity<>(errorDetailsDto, HttpStatus.BAD_REQUEST);
	}

}
