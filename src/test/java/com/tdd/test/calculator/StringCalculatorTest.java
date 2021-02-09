package com.tdd.test.calculator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

import com.tdd.main.calculator.StringCalculator;
import com.tdd.main.exception.NegativeNumberException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StringCalculatorTest {
	
	@Test
	@Order(1)
	public void testAddEmptyString() {
		String test = "";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(0,result);
	}
	
	@Test
	@Order(2)
	public void testAddOneNumber() {
		String test = "1";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(1,result);
	}
	
	@Test
	@Order(3)
	public void testAddTwoNumbers() {
		String test = "1,2";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(3,result);
	}
	
	@Test
	@Order(4)
	public void testAddManyNumbers() {
		String test = "1,2,3,4,5";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(15,result);
	}
	
	@Test
	@Order(5)
	public void testAddTwoNumbersInNewLine() {
		String test = "1\n2";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(3,result);
	}
	
	@Test
	@Order(6)
	public void testAddManyNumbersInNewLine() {
		String test = "1,2,3,4\n5";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(15,result);
	}
	
	@Test
	@Order(7)
	public void testAddManyNumbersWithCustomDelimiter() {
		String test = "//;\n1;2";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(3,result);
	}
	
	@Test
	@Order(8)
	public void testAddTwoNumbersIncludingNegative() {
		String test = "1\n-2";
		StringCalculator stringCalculator = new StringCalculator();
		try {
			assertThrows(NegativeNumberException.class, ()->
			stringCalculator.add(test));
		}
		catch(NegativeNumberException e) {
			assertEquals("negatives not allowed -2",e.getMessage());
		}
	}
	
	@Test
	@Order(9)
	public void testAddManyNumbersIncludingManyNegatives() {
		String test = "1\n-2,-3";
		StringCalculator stringCalculator = new StringCalculator();
		try {
			assertThrows(NegativeNumberException.class, ()->
			stringCalculator.add(test));
		}
		catch(NegativeNumberException e) {
			assertEquals("negatives not allowed -2 -3",e.getMessage());
		}
	}
	
	@AfterAll
	public void testGetCalledCount() {
		int result = StringCalculator.getCalledCount();
		assertEquals(9,result);
	}
}
