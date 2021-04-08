package com.shubham;

public class StringCalculator {

	public static int add(String numbers) {
		
		if (numbers.isEmpty()) {
			return 0;
		} else if (numbers.length() == 1) {
			return Integer.parseInt(numbers);
		}
		
		return -1;
		
	}

}
