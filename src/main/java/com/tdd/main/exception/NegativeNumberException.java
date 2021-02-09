package com.tdd.main.exception;

public class NegativeNumberException extends RuntimeException{
	
	private int negativeNumber;
	
	public NegativeNumberException(int n) {
		negativeNumber = n;
	}
	 
	static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "negatives not allowed " + negativeNumber;
	}
}
