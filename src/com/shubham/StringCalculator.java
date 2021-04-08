package com.shubham;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public static int add(String numbers) {
		
		if (numbers.isEmpty()) {
			return 0;
		} else if (numbers.length() == 1) {
			return intConveter(numbers);
		}else {
			String[] nums = numbers.split(",");
			List<Integer> numerical = StrArrToIntList(nums);
			return sum(numerical);
		}
		
	}
	
	private static int sum(List<Integer> numerical) {
		int sums = 0;
		for (Integer i : numerical) {
			sums += i;
		}
		return sums;
	}

	public static int intConveter(String num) {
		return Integer.parseInt(num);
	}

	public static List<Integer> StrArrToIntList(String[] nums) {
		List<Integer> intNums = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			intNums.add(intConveter(nums[i]));		
		}
		return intNums;
	}
}
