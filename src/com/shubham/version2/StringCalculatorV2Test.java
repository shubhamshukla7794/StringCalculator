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
}
