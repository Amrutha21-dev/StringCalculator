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
	
	static int count = 0;
	
	@Test
	@Order(1)
	public void testAddEmptyString() {
		count+=1;
		String test = "";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(0,result);
	}
	
	@Test
	@Order(2)
	public void testAddOneNumber() {
		count+=1;
		String test = "1";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(1,result);
	}
	
	@Test
	@Order(3)
	public void testAddTwoNumbers() {
		count+=1;
		String test = "1,2";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(3,result);
	}
	
	@Test
	@Order(4)
	public void testAddManyNumbers() {
		count+=1;
		String test = "1,2,3,4,5";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(15,result);
	}
	
	@Test
	@Order(5)
	public void testAddTwoNumbersInNewLine() {
		count+=1;
		String test = "1\n2";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(3,result);
	}
	
	@Test
	@Order(6)
	public void testAddManyNumbersInNewLine() {
		count+=1;
		String test = "1,2,3,4\n5";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(15,result);
	}
	
	@Test
	@Order(7)
	public void testAddManyNumbersWithCustomDelimiter() {
		count+=1;
		String test = "//;\n1;2";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(3,result);
	}
	
	@Test
	@Order(8)
	public void testAddTwoNumbersIncludingNegative() {
		count+=1;
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
		count+=1;
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
	
	@Test
	@Order(10)
	public void testAddManyNumbersWithLimit() {
		count+=1;
		String test = "//;\n1;2,1001";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(3,result);
	}
	
	@Test
	@Order(11)
	public void testAddManyNumbersWithLongDelimiter() {
		count+=1;
		String test = "//[***]\n1***2***3";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(6,result);
	}
	
	@Test
	@Order(12)
	public void testAddManyNumbersWithManyDelimiter() {
		count+=1;
		String test = "//[*][%]\n1*2%3";
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.add(test);
		assertEquals(6,result);
	}
	
	@AfterAll
	public void testGetCalledCount() {
		int result = StringCalculator.getCalledCount();
		assertEquals(count,result);
	}
}
