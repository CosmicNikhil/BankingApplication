package net.javaguides.banking.exception;

public class InsufficientFundsException extends RuntimeException{
	public InsufficientFundsException(String msg)
	{
		super(msg);
	}
}
