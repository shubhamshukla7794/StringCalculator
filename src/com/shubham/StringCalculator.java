package com.shubham;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public static int add(String numbers) {

		if (numbers.isEmpty()) {
			return 0;
		} else if (numbers.length() == 1) {
			return intConveter(numbers);
		} else {
//			String[] nums = numbers.split(",|\n");
//			List<Integer> numerical = StrArrToIntList(nums);

			int num = 0;
			List<Integer> numerical = new ArrayList<>();
			numbers = "." + numbers + ".";
			
			char[] charNum = numbers.toCharArray();
			
			for (int i = 0; i < charNum.length; i++) {
				if (num==0 && isNum(charNum[i])) {
					num=intConveter(charNum[i]);
				}
				if (isNum(charNum[i]) && isNum(charNum[i+1])) {
					num = num * 10 + intConveter(charNum[i+1]);
				}else if (isNum(charNum[i])) {
					numerical.add(num);
					num=0;
				}
			}

			return sum(numerical);
		}

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

	public static int intConveter(String num) {
		return Integer.parseInt(num);
	}
	
	private static int intConveter(char ch) {
		return Character.getNumericValue(ch);
	}

	public static List<Integer> StrArrToIntList(String[] nums) {
		List<Integer> intNums = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			intNums.add(intConveter(nums[i]));
		}
		return intNums;
	}
}
