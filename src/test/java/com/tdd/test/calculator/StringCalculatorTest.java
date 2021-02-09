package com.tdd.test.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tdd.main.calculator.StringCalculator;


public class StringCalculatorTest {
	
	@Test
	public void testAddEmptyString() {
		String test = "";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(0,result);
	}
	
	@Test
	public void testAddOneNumber() {
		String test = "1";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(1,result);
	}
	
	@Test
	public void testAddTwoNumbers() {
		String test = "1,2";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(3,result);
	}
}
