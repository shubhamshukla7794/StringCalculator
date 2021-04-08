package com.shubham.version2;

import java.util.ArrayList;
import java.util.List;

public class StringCalculatorV2 {

	public static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		} else if (numbers.length() == 1) {
			return intConverter(numbers);
		} else {
			if (numbers.startsWith("//")) {
				return customDelimiter(numbers);

			} else {
				return commaAndNewlineDelimiter(numbers);
			}
		}

	}

	private static int commaAndNewlineDelimiter(String numbers) {
		String[] numerical = splitStr(numbers, ",|\n");
		List<Integer> nums = StrArrToIntList(numerical);
		return sum(nums);
	}

	private static int customDelimiter(String numbers) {
		String[] tokens = splitStr(numbers, "\n");
		String delimiters = tokens[0];
		delimiters = delimiters.replace("//", "");
		delimiters = replaceDels(delimiters);
		String[] numerical = splitStr(tokens[1], delimiters);
		List<Integer> nums = StrArrToIntList(numerical);
		return sum(nums);
	}

	private static String replaceDels(String str) {

		if (str.contains("*") || str.contains("+") || str.contains("?") || str.contains("^") || str.contains("$")) {
			str = str.replace("*", "\\*");
			str = str.replace("+", "\\+");
			str = str.replace("?", "\\?");
			str = str.replace("^", "\\^");
			str = str.replace("$", "\\$");
		}

		return str;
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
