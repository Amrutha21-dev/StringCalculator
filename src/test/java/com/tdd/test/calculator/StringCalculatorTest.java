package com.tdd.test.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import com.tdd.main.calculator.StringCalculator;
import com.tdd.main.exception.NegativeNumberException;


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
	
	@Test
	public void testAddManyNumbers() {
		String test = "1,2,3,4,5";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(15,result);
	}
	
	@Test
	public void testAddTwoNumbersInNewLine() {
		String test = "1\n2";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(3,result);
	}
	
	@Test
	public void testAddManyNumbersInNewLine() {
		String test = "1,2,3,4\n5";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(15,result);
	}
	
	@Test
	public void testAddManyNumbersWithCustomDelimiter() {
		String test = "//;\n1;2";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(3,result);
	}
	
	@Test(expected = NegativeNumberException.class)
	public void testAddTwoNumbersIncludingNegative() {
		String test = "1\n-2";
		StringCalculator stringCalculator = new StringCalculator();
		try {
			stringCalculator.add(test);
		}
		catch(NegativeNumberException e) {
			assertEquals("negatives not allowed -2",e.getMessage());
			throw e;
		}
	}
}
