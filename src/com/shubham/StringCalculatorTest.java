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
}
