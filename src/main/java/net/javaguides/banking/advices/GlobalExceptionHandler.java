package net.javaguides.banking.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import net.javaguides.banking.exception.AccountNotFoundException;
import net.javaguides.banking.exception.InsufficientFundsException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<ApiError> handleResourceNotFound(AccountNotFoundException exception)
	{
		ApiError apiError = ApiError.builder().message(exception.getMessage()).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(apiError,apiError.getStatus());
	}
	
	@ExceptionHandler(InsufficientFundsException.class)
	public ResponseEntity<ApiError> handleInternalServerError(InsufficientFundsException exception)
	{
		ApiError apiError = ApiError.builder()
				.message(exception.getMessage())
				.status(HttpStatus.PAYMENT_REQUIRED)
				.build();
		return new ResponseEntity<>(apiError,apiError.getStatus());
	}
	
	
}
