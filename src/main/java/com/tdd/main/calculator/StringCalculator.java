package com.tdd.main.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.tdd.main.exception.NegativeNumberException;

public class StringCalculator {
	
	private static int calledCount = 0;
	
	public static int getCalledCount() {
		return calledCount;
	}
	public int add(String numbers) {
		calledCount+=1;
		if(numbers == null || numbers.isEmpty()) {
			return 0;
		}
		else {
			String regex = ",|\n";
			if(numbers.matches("//.\n.*")) {
				char delimiter = numbers.charAt(2);
				regex = ",|\n|"+delimiter;
				numbers = numbers.substring(4);
			}
			else if(numbers.contains("//[")) {
				String delimiter = numbers.substring(numbers.indexOf('[')+1,
						numbers.indexOf(']'));
				delimiter = Pattern.quote(delimiter);
				regex = ",|\n|"+delimiter;
				numbers = numbers.substring(numbers.indexOf(']')+2);
			}
			String[] numArray = numbers.split(regex);
			List<Integer> negativeNumbers = new ArrayList<>();
			int count = 0;
			for(String num : numArray) {
				int intNum = Integer.parseInt(num);
				if(intNum < 0) {
					negativeNumbers.add(intNum);
				}
				else if(intNum <= 1000){
					count += intNum;
				}
			}
			if(!negativeNumbers.isEmpty()) {
				throw new NegativeNumberException(negativeNumbers);
			}
			return count;
		}
	}
}
