package com.shubham;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	@Test
	void testEmptyStr() {
		assertEquals(0, StringCalculator.add(""));
	}

	@Test
	void testOneNumber() {
		assertEquals(3, StringCalculator.add("3"));
	}
	
	@Test
	void testTwoNumbers() {
		assertEquals(10, StringCalculator.add("3,7"));
	}
	
	@Test
	void testThreeNumbers() {		
		assertEquals(70, StringCalculator.add("10,10,50"));
	}
	
	@Test
	void testMultipleNumbers() {
		assertEquals(77, StringCalculator.add("10,20,40,7"));
	}
	
	@Test
	void testNumbersWithNewLine() {
		assertEquals(70, StringCalculator.add("10,10\n50"));
	}
	
	@Test
	void testCustomDelimiter() {
		assertEquals(3, StringCalculator.add("//;\\n1;2"));
	}
	
	@Test
	void testNegativeNumber() {
		try {
			StringCalculator.add("-10,45,-5,45,-5");
			fail("Expect an exception");
		} catch (RuntimeException e) {
			assertEquals("Negatives not allowed. -10,-5,-5", e.getMessage());
		}
	}
	
}
