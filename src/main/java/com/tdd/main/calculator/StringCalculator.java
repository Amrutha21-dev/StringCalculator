package com.tdd.main.calculator;

public class StringCalculator {
	public int add(String numbers) {
		if(numbers == null || numbers.isEmpty()) {
			return 0;
		}
		else {
			String[] numArray = numbers.split(",");
			int count = 0;
			for(String num : numArray) {
				count += Integer.parseInt(num);
			}
			return count;
		}
	}
}
