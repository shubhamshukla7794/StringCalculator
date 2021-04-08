package com.shubham.version2;

import java.util.ArrayList;
import java.util.List;

public class StringCalculatorV2 {
	
	private static int count = 0;

	public static int add(String numbers) {
		
		count++;
		
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
		return producingSum(numerical);
	}

	private static int customDelimiter(String numbers) {
		String[] tokens = splitStr(numbers, "\n");
		String delimiters = tokens[0];
		delimiters = delimiters.replace("//", "");
		delimiters = replaceDels(delimiters);
		String[] numerical = splitStr(tokens[1], delimiters);
		return producingSum(numerical);
	}
	
	private static int producingSum(String[] numerical) {
		List<List<Integer>> nums = StrArrToIntList(numerical);
		List<Integer> positive = nums.get(0);
		List<Integer> negative = nums.get(1);
		if (negative.size()>0) {
			throw new RuntimeException("Negatives not allowed. "+allNegatives(negative));
		}
		return sum(positive);
	}


	private static String allNegatives(List<Integer> negative) {
		StringBuilder all = new StringBuilder();
		for (int i : negative) {
			all.append(i);
			all.append(',');
		}
		all.deleteCharAt(all.length() - 1);
		return all.toString();
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

	private static List<List<Integer>> StrArrToIntList(String[] numerical) {
		List<List<Integer>> intNums = new ArrayList<>();
		List<Integer> positive = new ArrayList<>();
		List<Integer> negative = new ArrayList<>();
		for (int i = 0; i < numerical.length; i++) {
			if (intConverter(numerical[i])<0) {
				negative.add(intConverter(numerical[i]));
			} else {
				if (intConverter(numerical[i])<=1000) {
					positive.add(intConverter(numerical[i]));
				}
			}
		}
		intNums.add(positive);
		intNums.add(negative);
		return intNums;
	}

	private static String[] splitStr(String str, String expr) {
		return str.split(expr);
	}

	private static int intConverter(String num) {
		return Integer.parseInt(num);
	}

	public static Integer getCalledCount() {
		return count;
	}

}
