package com.shubham;

public class StringCalculator {

	public static int add(String numbers) {
		
		if (numbers.isEmpty()) {
			return 0;
		} else if (numbers.length() == 1) {
			return Integer.parseInt(numbers);
		}else {
			String[] nums = numbers.split(",");
			return Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
		}
		
	}

}
