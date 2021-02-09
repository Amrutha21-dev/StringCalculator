package com.tdd.main.calculator;

import java.util.ArrayList;
import java.util.List;

import com.tdd.main.exception.NegativeNumberException;

public class StringCalculator {
	public int add(String numbers) {
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
			String[] numArray = numbers.split(regex);
			List<Integer> negativeNumbers = new ArrayList<>();
			int count = 0;
			for(String num : numArray) {
				int intNum = Integer.parseInt(num);
				if(intNum < 0) {
					negativeNumbers.add(intNum);
				}
				else{
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
