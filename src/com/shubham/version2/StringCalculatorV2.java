package com.shubham.version2;

import java.util.ArrayList;
import java.util.List;

public class StringCalculatorV2 {

	public static int add(String number) {
		if (number.isEmpty()) {
			return 0;
		} else if (number.length() == 1) {
			return intConverter(number);
		} else {
			String[] numerical = splitStr(number, ",|\n");
			List<Integer> nums = StrArrToIntList(numerical);
			return sum(nums);
		}

	}

	private static int sum(List<Integer> nums) {
		int sums = 0;
		for (int i : nums) {
			sums += i;
		}
		return sums;
	}

	private static List<Integer> StrArrToIntList(String[] numerical) {
		List<Integer> intNums = new ArrayList<>();
		for (int i = 0; i < numerical.length; i++) {
			intNums.add(intConverter(numerical[i]));
		}
		return intNums;
	}

	private static String[] splitStr(String str, String expr) {
		return str.split(expr);
	}

	private static int intConverter(String num) {
		return Integer.parseInt(num);
	}

}
