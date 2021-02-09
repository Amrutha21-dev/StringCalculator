package com.tdd.main.exception;

import java.util.List;

public class NegativeNumberException extends RuntimeException{
	
	private List<Integer> negativeNumbers;
	
	public NegativeNumberException(List<Integer> n) {
		negativeNumbers = n;
	}
	 
	static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		String message = "negatives not allowed";
		for(Integer i:negativeNumbers) {
			message = message + " "+ i;
		}
		return message;
	}
}
