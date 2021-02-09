package com.tdd.main.calculator;

public class StringCalculator {
	public int add(String numbers) {
		if(numbers == null || numbers.isEmpty()) {
			return 0;
		}
		else {
			String[] numArray = numbers.split(",");
			if(numArray.length == 1) {
				return Integer.parseInt(numArray[0]);
			}
			else {
				return Integer.parseInt(numArray[0])+Integer.parseInt(numArray[1]);
			}
		}
	}
}
