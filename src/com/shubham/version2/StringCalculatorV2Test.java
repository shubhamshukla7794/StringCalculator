package com.shubham.version2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorV2Test {

	@Test
	void testEmptyStr() {
		assertEquals(0, StringCalculatorV2.add(""));
	}

	@Test
	void testOneNumber() {
		assertEquals(7, StringCalculatorV2.add("7"));
	}

	@Test
	void testTwoNumbers() {
		assertEquals(100, StringCalculatorV2.add("30,70"));
	}

	@Test
	void testMultipleNumbers() {
		assertEquals(77, StringCalculatorV2.add("20,50,3,4"));
	}

	@Test
	void testNumbersWithNewLine() {
		assertEquals(70, StringCalculatorV2.add("5,15\n50"));
	}

	@Test
	void testCustomDelimiter() {
		assertEquals(7, StringCalculatorV2.add("//;\n3;4"));
	}

	@Test
	void testNegativeNumber() {
		try {
			StringCalculatorV2.add("-10,45,-10,45");
			fail("Expect an exception");
		} catch (RuntimeException e) {
			assertEquals("Negatives not allowed. -10,-10", e.getMessage());
		}
	}

	@Test
	void testACallCount() {
		assertEquals(2, StringCalculatorV2.getCalledCount());// this is 3rd in order now in my case
	}

	@Test
	void testZCallCount() {
		assertEquals(10, StringCalculatorV2.getCalledCount());// this is 12th in order now in my case
	}

	@Test
	void testMultipleNumbersWithGreaterThan1000() {
		assertEquals(70, StringCalculatorV2.add("20,50,1024"));
	}

	@Test
	void testCustomDelimiterOfAnyLength() {
		assertEquals(70, StringCalculatorV2.add("//[***]\n15***15***40"));
	}

	@Test
	void testCustomMultipleDelimiterOfOneChar() {
		assertEquals(70, StringCalculatorV2.add("//[*][%]\n25*30%15"));
	}

	@Test
	void testCustomMultipleDelimiterOfAnyLength() {
		assertEquals(77, StringCalculatorV2.add("//[**][%%]\n15**25%%37"));
	}
}
