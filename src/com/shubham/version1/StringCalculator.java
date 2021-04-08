package com.shubham.version1;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	private static int count = 0;

	public static int add(String numbers) {

		count++;

		if (numbers.isEmpty()) {
			return 0;
		} else if (numbers.length() == 1) {
			return intConveter(numbers);
		} else {
			return allDelimiterMethod(numbers);
		}

	}

	private static int allDelimiterMethod(String numbers) {
		int num = 0;
		boolean flag = false;
		List<Integer> positive = new ArrayList<Integer>();
		List<Integer> negative = new ArrayList<Integer>();
		numbers = "." + numbers + ".";

		char[] charNum = numbers.toCharArray();

		for (int i = 0; i < charNum.length; i++) {
			if (num == 0 && isNum(charNum[i])) {
				num = intConveter(charNum[i]);
				if (charNum[i] > 0 && charNum[i - 1] == '-') {
					flag = true;
				}
			}
			if (isNum(charNum[i]) && isNum(charNum[i + 1])) {
				num = num * 10 + intConveter(charNum[i + 1]);
			} else if (isNum(charNum[i])) {
				if (flag) {
					negative.add(num * -1);
					flag = false;
				} else {
					if (num <= 1000) {
						positive.add(num);
					}
				}
				num = 0;
			}
		}
		if (negative.size() > 0) {
			throw new RuntimeException("Negatives not allowed. " + allNegatives(negative));
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

	private static boolean isNum(char ch) {
		return Character.isDigit(ch);
	}

	private static int sum(List<Integer> numerical) {
		int sums = 0;
		for (Integer i : numerical) {
			sums += i;
		}
		return sums;
	}

	private static int intConveter(String num) {
		return Integer.parseInt(num);
	}

	private static int intConveter(char ch) {
		return Character.getNumericValue(ch);
	}

	public static int getCalledCount() {
		return count;
	}
}
